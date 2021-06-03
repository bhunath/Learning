import java.util.Arrays;
import java.util.List;

public class MCQ {
    public static void main(String[] args) {
        // MCQ 1
        try {
            List ints = Arrays.asList(1, 2);
            List nums = ints;
            nums.add(3.14);
        }catch(Exception exception){

        }
        // MCQ 2
        System.out.println(Integer.toBinaryString(-1));
        char ch = (char)-1;
        int j =  (short)ch;
        int i =  ch & 0Xffff;
        System.out.print("Value of I : ");
        System.out.println(Integer.toBinaryString(i));
        System.out.print("Value of J : ");
        System.out.println(Integer.toBinaryString(j));
        System.out.println(i);
        System.out.println(j);

        // MCQ 3
        System.out.println("2 + 2 ="+2+2);
        System.out.println('a'+'a');
        System.out.println('a'-'a');
        System.out.println('b'-1);
        char[] characters = {'a','b','c'};
        System.out.println(characters);
        System.out.println(characters + "");
        int numbers[] = {1,2,3};
        System.out.println(numbers);
        int _int = 30;
    }

    
}
