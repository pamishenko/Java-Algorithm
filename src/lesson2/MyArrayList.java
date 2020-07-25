package lesson2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;


    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity : " + capacity);
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        return "MyArrayList{\n" +
                "list=" + Arrays.toString(list) +
                ",\n size=" + size +
                ",\n capacity=" + capacity +
                '}';
    }

    public void add(T item) {
        if (size == capacity){
            increase();
        }
        list[size] = item;
        size++;

    }

    public void add(int index, T item) {
        if (size == capacity){
            increase();
        }
        checkCorrectIndex(index);

        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public boolean remove(T item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        size--;
        list[size] = null;
        return true;
    }

    public T get(int index) {
        checkCorrectIndex(index);
        return list[index];
    }

    public void set(int index, T item) {
        checkCorrectIndex(index);
        list[index] = item;
    }

    public int size() {
        return size;
    }

    private void checkCorrectIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("no correct index" + index);
        }
    }

    public final int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    private void increase(){
        int capacityTemp = (int)(size * 1.618);
        T[] listTemp = (T[]) new Comparable[capacityTemp];
        for (int i = 0; i < list.length; i++) {
            listTemp[i] = list[i];
        }
        list = listTemp;
        setCapacity(capacityTemp);
    }


    public String selectionSort() {
        Date timeStart = new Date();

        for (int i = 0; i < size - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
        Date timeEnd = new Date();
        long time = timeEnd.getTime() - timeStart.getTime();
        return "Сортировка выбором: " + time + "мс";
    }

    public String insertionSort() {
        Date timeStart = new Date();

        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
        Date timeEnd = new Date();
        long time = timeEnd.getTime() - timeStart.getTime();
        return "Сортировка вставками: " + time + "мс";
    }

    public void bubbleSort() {
        boolean isSwapped;
        for (int i = size - 1; i > 0; i--) {
            isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                return;
            }
        }
    }


    public String bubbleSort(Comparator<T> comparator) {
        Date timeStart = new Date();

        boolean isSwapped;
        for (int i = size - 1; i > 0; i--) {
            isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (comparator.compare(list[j + 1], list[j]) < 0) {
                    swap(j + 1, j);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
        Date timeEnd = new Date();
        long time = timeEnd.getTime() - timeStart.getTime();
        return "Сортировка пузырьком: " + time + "мс";
    }

}
