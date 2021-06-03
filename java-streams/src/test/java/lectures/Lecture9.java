package lectures;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Lecture9 {

  @Test
  public void reduce() throws Exception {
    Integer[] integers = {1, 1, 1};

    final Integer sum = Arrays.stream(integers).
            reduce(10, Integer::sum);

    System.out.println(sum);

  }


}

