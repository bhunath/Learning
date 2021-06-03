package algo.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] intArray = {20,35,-15,7,55,1,-22};

        //doSelectionSort(intArray);
        doSelectionSortNew(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]+"\t");
        }

    }

    private static void doSelectionSortNew(int[] intArray) {
        for (int i = 0; i < intArray.length ; i++) {
            int indexValue = intArray[i];
            int smallestInt = indexValue;
            int smallestIndex = i;
            for (int j = smallestIndex+1; j < intArray.length ; j++) {
                if(intArray[j]<smallestInt){
                    smallestInt = intArray[j];
                    smallestIndex=j;
                }
            }
            intArray[i] = smallestInt;
            intArray[smallestIndex] = indexValue;
        }
    }

    private static void doSelectionSort(int[] intArray) {
        for (int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0 ; lastUnsortedIndex--) {
            int maxIndex = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if(intArray[i] > intArray[maxIndex]){
                    maxIndex  = i;
                }
            }
            swap(intArray,lastUnsortedIndex,maxIndex);
        }
    }

    public static void swap(int[] intArray,int i,int j){
        int temp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temp;
    }
}
