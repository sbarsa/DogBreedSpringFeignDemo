package com.sergiubarsa.openfeigndemo;

import com.sergiubarsa.openfeigndemo.dto.DogDto;
import com.sergiubarsa.openfeigndemo.feign.MainFeignClient;
import com.sergiubarsa.openfeigndemo.model.Dog;
import java.net.URI;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DogBreedService {

  private final MainFeignClient feignClient;

  public DogBreedService(MainFeignClient feignClient) {
    this.feignClient = feignClient;
  }

  public Dog getRandomDog() {
    DogDto dog = feignClient.getRandomBreed();
    String url = dog.message();
    return new Dog(url, extractBreed(url));
  }

  private Optional<String> extractBreed(String url) {
    URI uri = URI.create(url);
    String[] segments = uri.getPath().split("/");
    for (int i = 0; i < segments.length; i++) {
      if ("breeds".equals(segments[i]) && i + 1 < segments.length) {
        return Optional.of(segments[i + 1]);
      }
    }
    return Optional.empty();
  }
}
