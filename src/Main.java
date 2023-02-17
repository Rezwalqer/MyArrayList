import java.util.function.IntUnaryOperator;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[100000];
        Random random = new Random();
        IntUnaryOperator randomInt = i -> random.nextInt();
        Arrays.setAll(array, randomInt);
        int[] array1 = array.clone();
        int[] array2 = array.clone();
        IntegerArrayList integerArrayList = new IntegerArrayList(100000);
        for (int i = 0; i < 100000; i++) {
            integerArrayList.add(random.nextInt(1000));
        }


        long start3 = System.currentTimeMillis();
        System.out.println(integerArrayList.contains(777));
        System.out.print("время поиска: ");

        System.out.println(System.currentTimeMillis() - start3);


        long start = System.currentTimeMillis();
        sortBubble(array);
        System.out.println(System.currentTimeMillis() - start);

        long start1 = System.currentTimeMillis();
        sortSelection(array1);
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        sortInsertion(array2);
        System.out.println(System.currentTimeMillis() - start2);


    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }


}
