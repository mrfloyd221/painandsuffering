package com.painandsuffering.tests;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.painandsuffering.model.Order;
import com.painandsuffering.model.Position;
import com.painandsuffering.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.painandsuffering.controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Before;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class OrderControllerTest {
    @Autowired
    private OrderController controller;
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        User vlad = new User(2,"vova", new ArrayList<Order>());
        User kapri = new User(2,"kapri", new ArrayList<Order>());
        Position pos1 = new Position(1, "lama", 100);
        Position pos2 = new Position(2, "kapra", 200);
            mockMvc.perform(post("/shop/orders/").content(asJsonString(new Order(1, vlad, pos1, true))));
        mockMvc.perform(post("/shop/orders/").content(asJsonString(new Order(1, kapri, pos2, false))));

    }
    @Test
    public void controllerLoaded() throws Exception{
        assertThat(controller).isNotNull();
    }

    @Test
    public void getOrder() throws Exception {
        this.mockMvc.perform(get("/shop/orders/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));


    }
    @Test
    public void postOrder() throws Exception{
        Order order = new Order();
        order.setUser(new User(1, "vova", new ArrayList<Order>()));
        order.setPosition(new Position(1, "tea", 400));
        order.setComplete(true);
        this.mockMvc.perform(post("/shop/orders/").content(asJsonString(order))
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
        Order order = new Order(1, new User(2, "sasha", new ArrayList<Order>()), new Position(3, "apple", 40), true);


        this.mockMvc.perform(put("/shop/orders/")
                .content(asJsonString(order))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL))
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(jsonPath("$.userId").value(2))
                .andExpect(jsonPath("$.positionId").value(3))
                .andExpect(jsonPath("$.complete").value(true));
    }
    @Test
    public void deleteOrder() throws Exception{
        this.mockMvc.perform(delete("/shop/orders/2").accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isOk());
    }
    public static String asJsonString(final Object obj) {
        try {

            JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();
            String jsonContent = jacksonJsonProvider.toJson(obj);

            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
