package com.propify.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PropertyController.class)
class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PropertyService propertyService;

    @Test
    public void testSearch() throws Exception {
        this.mockMvc.perform(get("/properties/search")).andExpect(status().isOk());
        // TODO: add assertions
    }

    // TODO: add tests for other API methods
}
