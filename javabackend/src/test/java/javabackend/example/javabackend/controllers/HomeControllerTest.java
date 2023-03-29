package javabackend.example.javabackend.controllers;


import org.junit.jupiter.api.Test;
//import org.springframework.mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeControllerTest {

    @Test
    public void testGetOrders() throws Exception {
        javabackend.example.javabackend.controllers.HomeController controller = new javabackend.example.javabackend.controllers.HomeController();
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String modelAndView = controller.getOrders(); //    We call the getOrders method on the controller and capture the returned ModelAndView.

        assertEquals("home-page", modelAndView, "Expected view name 'home-page'"); //    We import assertEquals to compare the expected and actual values.
    }


//    We create a new instance of HomeController and MockHttpServletRequest and MockHttpServletResponse.
//    We use assertEquals to check if the view name returned by the getOrders method is "home-page".
//    If the test passes, it means that the getOrders method returns "home-page" as expected.

}