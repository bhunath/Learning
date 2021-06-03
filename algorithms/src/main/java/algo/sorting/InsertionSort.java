package algo.sorting;

import java.util.HashMap;

public class InsertionSort {

    public static void main(String[] args) {
        int[] intArray = {20,35,-15,7,55,1,-22};
        insertionSortAsc(intArray);
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]+"\t");
        }
        insertionSortDsc(intArray);
        System.out.println("\n");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]+"\t");
        }
    }

    private static void insertionSortDsc(int[] intArray) {
        for (int i = 1; i < intArray.length; i++) {
            int key = intArray[i];
            int j = i-1;
            while (j>=0 && key > intArray[j]){
                intArray[j+1] = intArray[j];
                j--;
            }
            intArray[j+1] = key;
        }
    }

    private static void insertionSortAsc(int[] intArray) {
        for(int firstUnSortedIndex = 1;firstUnSortedIndex < intArray.length;firstUnSortedIndex++){

            int newElement = intArray[firstUnSortedIndex];
            int i;
            for( i= firstUnSortedIndex ; i > 0 && intArray[i-1] > newElement ; i--){
                intArray[i] = intArray[i-1];
            }
            intArray[i] = newElement;
        }
    }
}
