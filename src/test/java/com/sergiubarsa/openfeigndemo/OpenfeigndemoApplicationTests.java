package com.sergiubarsa.openfeigndemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class OpenfeigndemoApplicationTests {

    @Autowired
    MockMvcTester mockMvc;

	@Test
	void contextLoads() {
	}

    @Test
    void testGetDogs() {
        MvcTestResult response = mockMvc.get()
                .uri("/")
                .exchange();

        assertThat(response).hasStatus(HttpStatus.OK).bodyText().contains("<html>");
    }

}
