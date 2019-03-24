package com.malexj.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Model {

  private static final String TO_STRING = "M:%s";

  private List<Integer> numbers;

  @Override
  public String toString() {
    return String.format(TO_STRING, numbers);
  }
}
