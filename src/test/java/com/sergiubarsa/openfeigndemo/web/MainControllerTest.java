package com.sergiubarsa.openfeigndemo.web;

import com.sergiubarsa.openfeigndemo.DogBreedService;
import com.sergiubarsa.openfeigndemo.model.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebMvcTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    MockMvcTester mvc;

    @MockitoBean
    DogBreedService dogBreedService;


    @Test
    void testMainPage() {
        Dog mockDog = new Dog("https://example.com/dog.jpg", "Labrador");
        when(dogBreedService.getRandomDog()).thenReturn(mockDog);

        MvcTestResult response = mvc.get().uri("/").exchange();

        assertThat(response).hasStatus(HttpStatus.OK).bodyText().contains("Breed: Labrador");
    }
}
