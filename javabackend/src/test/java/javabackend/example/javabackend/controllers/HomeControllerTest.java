package javabackend.example.javabackend.controllers;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class HomeControllerTest {

    @Test
    public void testGetOrders() throws Exception {
        HomeController controller = new HomeController();
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String modelAndView = controller.getOrders(); //    We call the getOrders method on the controller and capture the returned ModelAndView.
        System.out.println(controller.getOrders());
        assertEquals("home-page", modelAndView, "Expected view name 'home-page'"); //    We import assertEquals to compare the expected and actual values.
        System.out.println("The test 'GetOrders' is working properly.");
    }
//    We create a new instance of HomeController and MockHttpServletRequest and MockHttpServletResponse.
//    We use assertEquals to check if the view name returned by the getOrders method is "home-page".
//    If the test passes, it means that the getOrders method returns "home-page" as expected.

}