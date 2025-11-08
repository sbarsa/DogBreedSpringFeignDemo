package com.sergiubarsa.openfeigndemo.model;

import java.util.Optional;

public record Dog(String imageUrl, Optional<String> breed) {
}
