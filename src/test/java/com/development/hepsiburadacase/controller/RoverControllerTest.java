package com.development.hepsiburadacase.controller;

import com.development.hepsiburadacase.model.ResponseModel;
import com.development.hepsiburadacase.service.RoverService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * The type Rover controller test.
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(RoverController.class)
class RoverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoverService roverService;

    @InjectMocks
    private RoverController roverControllerUnderTest;


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        roverControllerUnderTest = new RoverController(roverService);
    }

    /**
     * Process rover endpoint test
     */
    @SneakyThrows
    @Test
    void processRover() {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setSuccess(true);
        responseModel.setMessageText("Success process.");
        when(roverService.processActions()).thenReturn(responseModel);
        ResultActions resultActions = mockMvc.perform(get("/api/process-rover"));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String response = resultActions.andReturn().getResponse().getContentAsString();
        assertThat(response).isEqualTo("{\"success\":true,\"messageText\":\"Success process.\"}");

    }

}