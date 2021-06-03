package mcq;

import java.util.Optional;

public class MCQ {

    public static void main(String[] args) throws InterruptedException {
//        //Q1
//        synchronized (args){
//            System.out.println(1);
//            args.wait();
//            System.out.println(2);
//        }
        // 2
//        Optional<String> tom = Optional.of("TOM");
//        tom = Optional.ofNullable(null);
//        System.out.println(tom.isEmpty());

        // 3
//        boolean b1 = true;
//        boolean b2 = false;
//        System.out.println(b1 & b2);

        //4
        Optional<String> tom = Optional.ofNullable(null);
        System.out.println("");
        System.out.println(tom.orElse("SUM"));

    }
}
