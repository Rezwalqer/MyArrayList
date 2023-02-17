import java.util.Arrays;
import java.util.Random;

public class IntegerArrayList implements StringList<Integer> {
    private Integer[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public IntegerArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity < 0");
        } else if (capacity == 0) {
            list = new Integer[DEFAULT_CAPACITY];
        } else {
            list = new Integer[capacity];
        }
    }

    public IntegerArrayList() {
        list = new Integer[DEFAULT_CAPACITY];
    }

    @Override
    public Integer add(Integer item) {
        grow();
        list[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkExp(index);
        grow();
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkExp(index);
        return list[index] = item;
    }

    @Override
    public Integer remove(Integer item) {
        if (!contains(item)) {
            throw new IllegalArgumentException("Ошибка");
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].equals(item)) {
                System.arraycopy(list, i + 1, list, i, list.length - i - 1);
                size--;
            }
        }
        return item;
    }

    @Override
    public Integer remove(int index) {
        checkExp(index);
        if (list[index] == null) {
            throw new IndexOutOfBoundsException("Элемента нет");
        }
        Integer s = list[index];
        System.arraycopy(list, index + 1, list, index, list.length - index - 1);
        size--;
        return s;
    }

    @Override
    public boolean contains(Integer item) {
        quickSort(list, 0, size - 1);
        return contains2(item);
    }

    private void sortInsertion() {
        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            int j = i;
            while (j > 0 && list[j - 1] >= temp) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = temp;
        }
    }

    private boolean contains2(int element) {
        int min = 0;
        int max = list.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == list[mid]) {
                return true;
            }

            if (element < list[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] != null && list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkExp(index);
        if (list[index] == null) {
            throw new IndexOutOfBoundsException("Элемента нет!");
        }
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Сравнение некорректное!");
        }
        if (size != otherList.size()) return false;
        for (int i = 0; i < size; i++) {
            if (list[i] != otherList.get(i)) return false;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        list = new Integer[size];

    }

    private void grow() {
        if (list[list.length - 1] != null) {
            list = Arrays.copyOf(list, list.length + list.length / 2);
        }
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(list, size);
    }

    private void checkExp(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Неверный индекс");
        }
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }
    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


}
