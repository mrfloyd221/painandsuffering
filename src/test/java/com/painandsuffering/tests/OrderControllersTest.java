package com.painandsuffering.tests;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.painandsuffering.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import com.painandsuffering.controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Before;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllersTest {
    @Autowired
    private OrderController controller;
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void controllerLoaded() throws Exception{
        assertThat(controller).isNotNull();
    }

    @Test
    public void getOrder() throws Exception {
        this.mockMvc.perform(get("/shop/orders/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value(1));
    }
    @Test
    public void postOrder() throws Exception{
        Order order = new Order(5,2,3,false);
        this.mockMvc.perform(post("/shop/orders/")
                .content(asJsonString(order))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL))
                .andExpect(status().isCreated());
    }
    @Test
    public void getAllOrders() throws Exception{
        this.mockMvc.perform(get("/shop/orders/").accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isOk());
    }
    @Test
    public void updateOrder() throws Exception{
        Order order = new Order();
        order.setId(0);
        order.setUserId(2);
        order.setPositionId(3);
        order.setComplete(true);
        this.mockMvc.perform(put("/shop/orders/0")
                .content(asJsonString(order))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL))
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(jsonPath("$.id").value(0))
                .andExpect(jsonPath("$.userId").value(2))
                .andExpect(jsonPath("$.positionId").value(3))
                .andExpect(jsonPath("$.complete").value(true));
    }
    @Test
    public void deleteOrder() throws Exception{
        this.mockMvc.perform(delete("/shop/orders/3").accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isOk());
    }
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
