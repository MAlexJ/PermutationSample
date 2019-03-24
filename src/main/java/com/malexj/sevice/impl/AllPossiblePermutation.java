package com.malexj.sevice.impl;

import com.malexj.model.Model;
import com.malexj.sevice.IPermutation;
import lombok.extern.log4j.Log4j;

import java.util.*;
import java.util.stream.Collectors;

/** Given a collection of numbers, return all possible permutations */
@Log4j
public class AllPossiblePermutation implements IPermutation {

  @Override
  public List<Model> permute(int[] nums) {
    List<Integer> input = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toList());

    List<List<Integer>> output = permute(input);
    return output.stream()
            .map(Model::new)
            .collect(Collectors.toList());
  }

  private List<List<Integer>> permute(List<Integer> input) {

    List<List<Integer>> output = new ArrayList<>();

    if (Objects.isNull(input) || input.isEmpty()) {
      output.add(new ArrayList<>());
      return output;
    }

    List<Integer> list = new ArrayList<>(input);

    Integer head = list.get(0);

    List<Integer> rest = list.subList(1, list.size());

    for (List<Integer> permutations : permute(rest)) {
      List<List<Integer>> subLists = new ArrayList<>();

      for (int i = 0; i <= permutations.size(); i++) {
        List<Integer> subList = new ArrayList<>(permutations);
        subList.add(i, head);
        subLists.add(subList);
      }

      output.addAll(subLists);
    }

    return output;
  }
}
