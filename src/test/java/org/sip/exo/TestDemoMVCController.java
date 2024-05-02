package org.sip.exo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.sip.exo.controllers.DemoMVCController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DemoMVCController.class)
public class TestDemoMVCController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDisplayMessage() throws Exception {
        mockMvc.perform(get("/ynov"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Ynov"));
    }
}

