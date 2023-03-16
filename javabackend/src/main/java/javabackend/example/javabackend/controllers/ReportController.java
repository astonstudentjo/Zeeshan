package javabackend.example.javabackend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import javabackend.example.javabackend.Service.ProductsService;
import javabackend.example.javabackend.models.Products;
import javabackend.example.javabackend.models.order_items;
import javabackend.example.javabackend.models.orders;
import javabackend.example.javabackend.models.users;
import javabackend.example.javabackend.repositories.ProductsRepository;
import javabackend.example.javabackend.repositories.UsersRepository;
import javabackend.example.javabackend.repositories.ordersRepository;
import javabackend.example.javabackend.repositories.ordersItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {
    @Autowired
    private final ProductsRepository productsRepository;
    @Autowired

    private final ProductsService productsService;
    @Autowired

    private final UsersRepository UsersRepository;
    @Autowired

    private final ordersRepository orderRepository;
    @Autowired

    private final ordersItemRepository orderItemRepository;



    @Autowired
    public ReportController(ProductsRepository productsRepository, ProductsService productsService, UsersRepository usersRepository, ordersRepository orderRepository, ordersItemRepository orderItemRepository){
        super();
        this.productsRepository = productsRepository;
        this.productsService = productsService;
        this.UsersRepository = usersRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

//    This is for the main page
    @GetMapping("/Report")
    public String generateReport() {
        return "Reports";
    }

//    This is for the stock report

    @GetMapping("/Report/Stock")
    public String generateStockReport(Model model) {
        List<Products> products = productsRepository.findAll();
        model.addAttribute("products", products);
        System.out.println("Stock Report generated");
        return "Stock-Report";
    }

    //      This is for the Users Reports
    @GetMapping("/Report/Users")
    public String generateUsersReport(Model model) {
        List<orders> orders = orderRepository.findAll();
        List<order_items> order_items = orderItemRepository.findAll();
        List<users> users = (List<javabackend.example.javabackend.models.users>) UsersRepository.findAll();



        Map<Integer, Integer> userOrders = new HashMap<>();
        for (orders order : orders) {
            int userId = order.getUser_id();
            userOrders.put(userId, userOrders.getOrDefault(userId, 0) + 1);
        }

        List<Map<String, Object>> userOrderData = new ArrayList<>();
        for (users user : users) {
            Map<String, Object> userOrder = new HashMap<>();
            userOrder.put("user", user);
            int numOrders = userOrders.getOrDefault(user.getId(), 0);
            int numItems = 0;
            for (order_items order_item : order_items) {
                if (orders.stream().filter(o -> o.getId() == order_item.getOrder_id())
                        .anyMatch(o -> o.getUser_id() == user.getId())) {
                    numItems += order_item.getQuantity();
                }
            }
            userOrder.put("numOrders", numOrders);
            userOrder.put("numItems", numItems);
            userOrderData.add(userOrder);
        }

        model.addAttribute("userOrderData", userOrderData);
        System.out.println("User Report generated");
        return "User-Report";
    }


    @Autowired
    private ordersRepository ordersRepository;

    //    this is for daily sales report
    @GetMapping("/Report/Sales/Today")
    public String generateDailySalesReport(Model model) {
        LocalDateTime startDate = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime endDate = LocalDateTime.now().with(LocalTime.MAX);
        List<orders> orders = orderRepository.findAll();
        List<order_items> order_items = orderItemRepository.findAll();
        List<Products> products = productsRepository.findAll();

        double totalSales = 0;
        int totalQuantity = 0;
        String Title = "Today's Sales Report for " + LocalDate.now();
        String url = "/Report/Sales/Today/pdf";


        List<orders> filteredOrders = new ArrayList<>();
        for (orders order : orders) {
            if (order.getCreated_at().after(Timestamp.valueOf(startDate)) && order.getCreated_at().before(Timestamp.valueOf(endDate))) {
                filteredOrders.add(order);
            }
        }


        List<order_items> filteredOrderItems = new ArrayList<>();
        for (order_items order_item : order_items) {
            if (filteredOrders.stream().anyMatch(o -> o.getId() == order_item.getOrder_id())) {
                filteredOrderItems.add(order_item);
            }
        }

        List<Products> filteredProducts = new ArrayList<>();

        for (Products product : products) {
            if (filteredOrderItems.stream().anyMatch(o -> o.getProduct_id() == product.getId())) {
                filteredProducts.add(product);
            }
        }

        for (order_items order_item : filteredOrderItems) {
            totalSales += order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice();
            totalQuantity += order_item.getQuantity();
        }

        List<Map<String, Object>> sale = new ArrayList<>();
        for (order_items order_item : filteredOrderItems) {
            Map<String, Object> saleItem = new HashMap<>();
            saleItem.put("order_id", order_item.getOrder_id());
            saleItem.put("product_name", filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getName());
            saleItem.put("quantity", order_item.getQuantity());
            saleItem.put("total_price", order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice());
            saleItem.put("created_at", filteredOrders.stream().filter(o -> o.getId() == order_item.getOrder_id()).findFirst().get().getCreated_at());
            sale.add(saleItem);
        }

        model.addAttribute("Title", Title);
        model.addAttribute("url", url);
        model.addAttribute("sale", sale);
        model.addAttribute("totalSales", String.format("%.2f", totalSales));
        model.addAttribute("totalQuantity", totalQuantity);
        System.out.println("Daily Sales Report generated");





        return "Sales-Report";
    }


    //    this is for Weelky sales report
    @GetMapping("/Report/Sales/ThisWeek")
    public String generateWeeklySalesReport(Model model) {
        LocalDateTime startDate = LocalDateTime.now().minusDays(7);
        LocalDateTime endDate = LocalDateTime.now();

        List<orders> orders = orderRepository.findAll();
        List<order_items> order_items = orderItemRepository.findAll();
        List<Products> products = productsRepository.findAll();

        double totalSales = 0;
        int totalQuantity = 0;
        String Title = "This Weeks Sales Report for " + startDate.toLocalDate() + " to " + endDate.toLocalDate();
        String url = "/Report/Sales/ThisWeek/pdf";




        List<orders> filteredOrders = new ArrayList<>();
        for (orders order : orders) {
            if (order.getCreated_at().after(Timestamp.valueOf(startDate)) && order.getCreated_at().before(Timestamp.valueOf(endDate))) {
                filteredOrders.add(order);
            }
        }


        List<order_items> filteredOrderItems = new ArrayList<>();
        for (order_items order_item : order_items) {
            if (filteredOrders.stream().anyMatch(o -> o.getId() == order_item.getOrder_id())) {
                filteredOrderItems.add(order_item);
            }
        }

        List<Products> filteredProducts = new ArrayList<>();

        for (Products product : products) {
            if (filteredOrderItems.stream().anyMatch(o -> o.getProduct_id() == product.getId())) {
                filteredProducts.add(product);
            }
        }

        for (order_items order_item : filteredOrderItems) {
            totalSales += order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice();
            totalQuantity += order_item.getQuantity();
        }

        List<Map<String, Object>> sale = new ArrayList<>();
        for (order_items order_item : filteredOrderItems) {
            Map<String, Object> saleItem = new HashMap<>();
            saleItem.put("order_id", order_item.getOrder_id());
            saleItem.put("product_name", filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getName());
            saleItem.put("quantity", order_item.getQuantity());
            saleItem.put("total_price", order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice());
            saleItem.put("created_at", filteredOrders.stream().filter(o -> o.getId() == order_item.getOrder_id()).findFirst().get().getCreated_at());
            sale.add(saleItem);
        }

        model.addAttribute("Title", Title);
        model.addAttribute("url", url);
        model.addAttribute("sale", sale);
        model.addAttribute("totalSales", String.format("%.2f", totalSales));
        model.addAttribute("totalQuantity", totalQuantity);
        System.out.println("Weekly Sales Report generated");





        return "Sales-Report";
    }


    //    this is for Monthly sales report
    @GetMapping("/Report/Sales/ThisMonth")
    public String generateMonthlySalesReport(Model model) {
        LocalDateTime startDate = LocalDateTime.now().minusDays(30);
        LocalDateTime endDate = LocalDateTime.now();

        List<orders> orders = orderRepository.findAll();
        List<order_items> order_items = orderItemRepository.findAll();
        List<Products> products = productsRepository.findAll();

        double totalSales = 0;
        int totalQuantity = 0;
        String Title = "This Months Sales Report for " + startDate.toLocalDate() + " to " + endDate.toLocalDate();
        String url = "/Report/Sales/ThisMonth/pdf";



        List<orders> filteredOrders = new ArrayList<>();
        for (orders order : orders) {
            if (order.getCreated_at().after(Timestamp.valueOf(startDate)) && order.getCreated_at().before(Timestamp.valueOf(endDate))) {
                filteredOrders.add(order);
            }
        }


        List<order_items> filteredOrderItems = new ArrayList<>();
        for (order_items order_item : order_items) {
            if (filteredOrders.stream().anyMatch(o -> o.getId() == order_item.getOrder_id())) {
                filteredOrderItems.add(order_item);
            }
        }

        List<Products> filteredProducts = new ArrayList<>();

        for (Products product : products) {
            if (filteredOrderItems.stream().anyMatch(o -> o.getProduct_id() == product.getId())) {
                filteredProducts.add(product);
            }
        }

        for (order_items order_item : filteredOrderItems) {
            totalSales += order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice();
            totalQuantity += order_item.getQuantity();
        }

        List<Map<String, Object>> sale = new ArrayList<>();
        for (order_items order_item : filteredOrderItems) {
            Map<String, Object> saleItem = new HashMap<>();
            saleItem.put("order_id", order_item.getOrder_id());
            saleItem.put("product_name", filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getName());
            saleItem.put("quantity", order_item.getQuantity());
            saleItem.put("total_price", order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice());
            saleItem.put("created_at", filteredOrders.stream().filter(o -> o.getId() == order_item.getOrder_id()).findFirst().get().getCreated_at());
            sale.add(saleItem);
        }

        model.addAttribute("Title", Title);
        model.addAttribute("url", url);
        model.addAttribute("sale", sale);
        model.addAttribute("totalSales", String.format("%.2f", totalSales));
        model.addAttribute("totalQuantity", totalQuantity);
        System.out.println("Monthly Sales Report generated");





        return "Sales-Report";
    }


    //    this is for Full sales report
    @GetMapping("/Report/Sales")
    public String generateFullSalesReport(Model model) {
        List<orders> orders = orderRepository.findAll();
        List<order_items> order_items = orderItemRepository.findAll();
        List<Products> products = productsRepository.findAll();

        double totalSales = 0;
        int totalQuantity = 0;
        String Title = "Full Sales Report";
        String url = "/Report/Sales/pdf";




        List<orders> filteredOrders = new ArrayList<>();
        for (orders order : orders) {
            filteredOrders.add(order);
        }


        List<order_items> filteredOrderItems = new ArrayList<>();
        for (order_items order_item : order_items) {
            if (filteredOrders.stream().anyMatch(o -> o.getId() == order_item.getOrder_id())) {
                filteredOrderItems.add(order_item);
            }
        }

        List<Products> filteredProducts = new ArrayList<>();

        for (Products product : products) {
            if (filteredOrderItems.stream().anyMatch(o -> o.getProduct_id() == product.getId())) {
                filteredProducts.add(product);
            }
        }

        for (order_items order_item : filteredOrderItems) {
            totalSales += order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice();
            totalQuantity += order_item.getQuantity();
        }

        List<Map<String, Object>> sale = new ArrayList<>();
        for (order_items order_item : filteredOrderItems) {
            Map<String, Object> saleItem = new HashMap<>();
            saleItem.put("order_id", order_item.getOrder_id());
            saleItem.put("product_name", filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getName());
            saleItem.put("quantity", order_item.getQuantity());
            saleItem.put("total_price", order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice());
            saleItem.put("created_at", filteredOrders.stream().filter(o -> o.getId() == order_item.getOrder_id()).findFirst().get().getCreated_at());
            sale.add(saleItem);
        }

        model.addAttribute("Title", Title);
        model.addAttribute("url", url);
        model.addAttribute("sale", sale);
        model.addAttribute("totalSales", String.format("%.2f", totalSales));
        model.addAttribute("totalQuantity", totalQuantity);
        System.out.println("Full Sales Report generated");

        return "Sales-Report";
    }

}
