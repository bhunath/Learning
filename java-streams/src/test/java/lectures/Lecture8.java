package lectures;


import beans.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {

  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );

    final Map<String, List<String>> groupByNames = names.stream().collect(Collectors.groupingBy(String::toString));
    groupByNames.forEach((name,values)-> System.out.println(name + ": " + values.size()));

    final Map<String, Long> groupByNameWithCount = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    groupByNameWithCount.forEach((name,count)-> System.out.println(name + " > " + count));

  }

}