package org.example;

import java.util.Arrays;
import java.util.Random;

public class IntegerListImpl implements IntegerList {

    private final int DEFAULT_SIZE = 10;
    private final int MULTIPLIKATOR = 2;
    private Integer[] store;
    private int size = 0;

    public IntegerListImpl() {
        this.store = new Integer[DEFAULT_SIZE];
    }

    public IntegerListImpl(int initialSize) {
        this.store = new Integer[initialSize];
    }

    public IntegerListImpl(int initialSize, String random){
        this.size = initialSize;
        this.store = new Integer[initialSize];
        Random rand = new Random();
        for(int i = 0; i<initialSize;i++){
            store[i] = rand.nextInt(1000);
        }
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        validateSize();

        store[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateItem(item);
        validateSize();

        if(index<0){
            throw new IndexOutOfBoundsException();
        }else if (size == 0) {
            store[index] = item;
            size++;
        } else if (store[index] != null) {
            System.arraycopy(store, index, store, index + 1, size - (index));
            store[index] = item;
            size++;
        } else if (store[index-1] == null) {
            add(index - 1, item);
        } else {
            store[index] = item;
            size++;
        }

        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);

        store[index] = item;
        return item;
    }

    /*
        @Override
        public Integer remove(Integer item) {
            validateItem(item);
            int index = indexOf(item);
            remove(index);

            return item;
        }
    */
    @Override
    public Integer remove(int index) {
        validateIndex(index);

        Integer tmp = store[index];
        System.arraycopy(store, index + 1, store, index, size - index);
        size--;
        return tmp;
    }

    @Override
    public boolean contains(Integer item) {
        validateItem(item);
        sortSelection();

        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        validateItem(item);
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (store[i] == item) {
                index = i;
                break;
            }
        }

        return index;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateItem(item);

        int index = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (store[i] == item) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int get(int index) {
        validateIndex(index);

        return store[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return store.equals(otherList.toArray());
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
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(store, size);
    }

    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "store=" + Arrays.toString(store) +
                ", size=" + size +
                '}';
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void validateSize() {
        if (size == store.length) {
            Integer[] extendedArray;
            extendedArray = Arrays.copyOf(store, size * MULTIPLIKATOR);
            store = extendedArray;
        }
    }

    private void sortInsertion(){
        for (int i = 1; i < store.length; i++) {
            int temp = store[i];
            int j = i;
            while (j > 0 && store[j - 1] >= temp) {
                store[j] = store[j - 1];
                j--;
            }
            store[j] = temp;
        }
    }
    private void sortSelection(){
        for (int i = 0; i < 11; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < store.length; j++) {
                if (store[j] < store[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(store, i, minElementIndex);
        }
    }

    private void sortBubble(){
        for (int i = 0; i < store.length - 1; i++) {
            for (int j = 0; j < store.length - 1 - i; j++) {
                if (store[j] > store[j + 1]) {
                    swapElements(store, j, j + 1);
                }
            }
        }
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        Integer tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private boolean binarySearch(int element) {
        int min = 0;
        int max = store.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == store[mid]) {
                return true;
            }

            if (element < store[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
