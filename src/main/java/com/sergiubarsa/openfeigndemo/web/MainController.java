package com.sergiubarsa.openfeigndemo.web;

import com.sergiubarsa.openfeigndemo.DogBreedService;
import com.sergiubarsa.openfeigndemo.model.Dog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private final DogBreedService dogService;

  public MainController(DogBreedService dogService) {
    this.dogService = dogService;
  }

  @GetMapping("/")
  public String get() {
    Dog randomDog = dogService.getRandomDog();
    return """
        <html>
          <body>
            <img src='%s' alt='Dog Image' style='max-width:400px;'/>
            <br/>
            <h2>Breed: %s</h2>
            <h3>Original URL: %s</h3>
          </body>
        </html>""".formatted(
        randomDog.imageUrl(), randomDog.breed().orElse("Breed unknown"), randomDog.imageUrl());
  }
}
