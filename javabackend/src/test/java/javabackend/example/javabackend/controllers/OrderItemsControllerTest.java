package javabackend.example.javabackend.controllers;


import javabackend.example.javabackend.Service.OrderItemsService;
import javabackend.example.javabackend.repositories.ordersItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
public class OrderItemsControllerTest {

    @Mock
    private OrderItemsService orderItemsServiceMock;

    @Mock
    private ordersItemRepository ordersItemRepositoryMock;

    @Mock
    private Model modelMock;

    @InjectMocks
    private OrderItemsController orderItemsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void testGetOrdersItems() {
//        List<order_items> orderItemsList = new ArrayList<>();
//        orderItemsList.add(new order_items(1, 1, "product1", 2, 20.0F));
//        orderItemsList.add(new order_items(2, 1, "product2", 3, 30.0F));
//        when(ordersItemRepositoryMock.findAll()).thenReturn(orderItemsList);
//
//        String viewName = orderItemsController.getOrdersItems(modelMock);
//        assertThat(viewName).isEqualTo("Orders-Item");
//        assertThat(modelMock.containsAttribute("order_items")).isTrue();
//        assertThat(modelMock.getAttribute("order_items")).isEqualTo(orderItemsList);
//    }
//
//    @Test
//    void testGetSpecificItem() {
//        List<order_items> orderItemsList = new ArrayList<>();
//        orderItemsList.add(new order_items(1, 1, "product1", 2, 20.0F));
//        orderItemsList.add(new order_items(2, 1, "product2", 3, 30.0F));
//        when(ordersItemRepositoryMock.findAll()).thenReturn(orderItemsList);
//
//        String viewName = orderItemsController.getSpecificItem(1, modelMock);
//        assertThat(viewName).isEqualTo("Orders-Item");
//        assertThat(modelMock.containsAttribute("order_items")).isTrue();
//
//        List<order_items> filteredItems = new ArrayList<>();
//        filteredItems.add(new order_items(1, 1, "product1", 2, 20.0F));
//        assertThat(modelMock.getAttribute("order_items")).isEqualTo(filteredItems);
//    }
}

