package com.example.RealEstateManagement.controller;

import com.example.RealEstateManagement.model.RealEstateAgent;
import com.example.RealEstateManagement.service.RealEstateAgentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@WebMvcTest(RealEstateAgentController.class)
class RealEstateAgentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RealEstateAgentService realEstateAgentService;

    @Test
    @DisplayName("Should be able to get all the realestateagent")
    public void testGetAllRealEstateAgent() throws Exception {
        List<RealEstateAgent> mockRealEstateAgents = new ArrayList<>();
        RealEstateAgent realEstateAgent = new RealEstateAgent(
                1L,
                "John Doe",
                "doe.doe@example.com",
                "143-455-7790",
                null
        );
        mockRealEstateAgents.add(realEstateAgent);
        when(realEstateAgentService.getAllRealEstateAgent()).thenReturn(mockRealEstateAgents);

        mockMvc.perform(get("/realestateagents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].email").value("doe.doe@example.com"))
                .andExpect(jsonPath("$[0].phone").value("143-455-7790"));
    }

    @Test
    @DisplayName("Should be able to create a new RealEstateAgent")
    public void testCreateRealEstateAgent() throws Exception {
        RealEstateAgent newRealEstateAgent = new RealEstateAgent(
                1L,
                "John Doe",
                "doe.doe@example.com",
                "143-455-7790",
                null);

        // Convert the RealEstateAgent object to JSON
        String jsonRequest = new ObjectMapper().writeValueAsString(newRealEstateAgent);

        mockMvc.perform(post("/realestateagents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk());

        verify(realEstateAgentService, times(1)).createRealEstateAgent(any(RealEstateAgent.class));
    }

}