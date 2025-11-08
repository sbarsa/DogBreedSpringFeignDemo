package com.sergiubarsa.openfeigndemo.feign;

import com.sergiubarsa.openfeigndemo.dto.DogDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="MainFeignClient", url="https://dog.ceo/api")
public interface MainFeignClient {

  @GetMapping("/breeds/image/random")
  DogDto getRandomBreed();
}
