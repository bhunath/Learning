package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    people.stream().
            filter(person -> person.getAge() <= 18)
            .limit(10)
            .forEach(System.out::println);
    // 2. Then change implementation to find first 10 people

  }

  public <T extends Number> T add(T a, T b){
    return  a;
  }

//  public Number add(Number a, Number b){
//    return  a + b;
//  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

  }
}
