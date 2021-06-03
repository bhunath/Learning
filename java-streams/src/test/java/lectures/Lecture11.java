package lectures;

import com.google.common.collect.ImmutableList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  static int x = 50;

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
      long count = names.stream().filter(s -> s.startsWith("j")).count();
      final List<String> collectNames = names.stream().flatMap(name -> Stream.of(name.split("")))
            .collect(Collectors.toList());

    System.out.println(collectNames);

  }

  public static void main(String[] args) {
      int i[][] = new int[3][];
      i[1] = new int[]{1,2,3};

      int x =0,y=10;
      int $ = 10;
      try{
        y /= x;
      }catch(Exception exception){
        System.out.println(exception);
      }

      LocalDate date1 = LocalDate.of(2016, Month.JANUARY, 1);
      LocalDate date2 = LocalDate.of(2017, Month.JUNE, 1);
      Period p = Period.between(date1, date2);
      System.out.print(p.getYears() + ":" + p.getMonths() + ":" + p.getDays());

      Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
      integerStream.filter(integer -> integer %2 == 1);
      integerStream.forEach(System.out::println);
  }

  public interface  test{
      static void print(){

      }
  }
}
