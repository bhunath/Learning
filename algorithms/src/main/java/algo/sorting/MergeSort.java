package algo.sorting;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.DoubleToIntFunction;
import java.util.function.IntBinaryOperator;

public class MergeSort {

    public static void main(String[] args) {
        int[] intArray = {1,2,3};
        mergeSort(intArray,0,intArray.length-1);
        IntBinaryOperator intBinaryOperator = (int a, int b) -> a + b;
    }

    private static void mergeSort(int[] intArray, int i, int lastIndex) {
        if(i<lastIndex){
            int middleIndex = (i+lastIndex)/2;
            mergeSort(intArray,i,middleIndex);
            mergeSort(intArray,middleIndex+1,lastIndex);
            merge(intArray,i,middleIndex,lastIndex);
        }
    }

    boolean flag = true;

    class Inner{

        public void test(){
            if(MergeSort.this.flag) {
                print();
            }
        }
    }

    public void print(){
        System.out.print("Hello");
    }

    private static void merge(int[] intArray, int i, int middleIndex, int lastIndex) {
        
    }

}
