package javabackend.example.javabackend.controllers;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest {

    @Test
    public void testGetOrders() throws Exception {
        HomeController controller = new HomeController();
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String modelAndView = controller.getOrders(); //    We call the getOrders method on the controller and capture the returned ModelAndView.

        assertEquals("home-page", modelAndView, "Expected view name 'home-page'"); //    We import assertEquals to compare the expected and actual values.
    }


//    We create a new instance of HomeController and MockHttpServletRequest and MockHttpServletResponse.
//    We use assertEquals to check if the view name returned by the getOrders method is "home-page".
//    If the test passes, it means that the getOrders method returns "home-page" as expected.

}