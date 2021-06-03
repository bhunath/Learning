package mcq;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Test test = new Test();
        //System.out.println(test.x + " : "+ test.y);
        long counter = 1;
//        for (int i = 0; i < 10; i++) {
//            System.out.println("tem"+(counter++));
//        }
        List<String> ee = new ArrayList();
        for(String v :ee){
            System.out.println(v);
        }
    }

}

class Test{
    protected int x,y;
}
