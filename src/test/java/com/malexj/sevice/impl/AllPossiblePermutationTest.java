package com.malexj.sevice.impl;

import com.malexj.model.Model;
import com.malexj.sevice.IPermutation;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@Log4j
public class AllPossiblePermutationTest {

  private IPermutation permutation = new AllPossiblePermutation();;

  @Test
  public void testPermutation() {
    // give
    int[] input = {1, 2, 3};

    // when
    List<Model> permute = permutation.permute(input);

    // then
    log.debug("permute: " + permute);
    assertEquals(6, permute.size());
  }
}
