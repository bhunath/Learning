package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  int a = 1;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Lecture5 lecture5 = (Lecture5) o;
    return a == lecture5.a;
  }

  @Override
  public int hashCode() {
    return Objects.hash(a);
  }

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    final ImmutableList<Car> cars = MockData.getCars();
    final double asDouble = cars.stream().mapToDouble(Car::getPrice).average().getAsDouble();


    System.out.println(asDouble);

    
  }


}



