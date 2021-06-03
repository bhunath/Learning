import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

public class OCA {


    void m(int x){
        System.out.println("int value : "+ x );
    }

    void m(char x){
        System.out.println("char value : "+x);
    }

    public static void main(String[] args) {

        localDateQuestion();
        stringManipulationInSysOut();
        overloading();
        predicateStringProcessor();
    }

    private static void predicateStringProcessor() {
        System.out.println("predicateStringProcessor----------------------------------");
        String[] strings = {"a","A","aa"};
        Predicate<String> predicate = s -> s.toUpperCase().substring(0,1).equals("A");
        predicateStringProcessor(strings,predicate);
    }

    private static void predicateStringProcessor(String[] strings, Predicate<String> predicate) {
        for (String value:strings) {
            if(predicate.test(value)){
                System.out.println(value);
            }
        }
    }

    private static void overloading() {
        OCA oca = new OCA();
        int x = '5';
        System.out.println(x);
        oca.m(x);
        oca.m('5');
    }


    private static void stringManipulationInSysOut() {
        String value = "10";
        //boolean result = value != 5;
        //System.out.println("Output is "+ 10 != 5);
        //boolean result = 10.23f != 10;
    }

    private static void localDateQuestion() {
        LocalDate localDate = LocalDate.of(2012, 1, 11);
        Period twoMonthPeriod = Period.ofMonths(2);
        LocalDate adjustedTime = localDate.minus(twoMonthPeriod);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yy");
        String formattedDate = dateTimeFormatter.format(adjustedTime);
        System.out.println(formattedDate);
    }


}
