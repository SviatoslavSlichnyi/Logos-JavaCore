package specialtasks.collections.list;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public MyArrayList(int size) {

        if (size <= 0) {
            throw new IllegalArgumentException("Illegal capacity: " + size);
        }

        array = new Object[size];
        capacity = size;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T element) {
        if (isEnoughCapacity()) {
            expandCapacity();
        }

        array[size] = element;
        ++size;

        return true;
    }

    @Override
    public void add(int index, T element) {
        if (isIncorrectInsertIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        if (index >= size) {
            add(element);
            return;
        }

        if (isEnoughCapacity()) {
            expandCapacity();
        }

        Object[] newArray = createArrayWithInsertedElement(index, element);
        replaceCurrentArrayIntoAnother(newArray);

        ++size;
    }

    private boolean isIncorrectInsertIndex(int index) {
        return index < 0 || (size == 0 && index != 0);
    }

    private Object[] createArrayWithInsertedElement(int index, T element) {
        Object[] newArray = new Object[capacity];

        //copy all elements until element with index
        System.arraycopy(array, 0, newArray, 0, index);

        //insert element
        newArray[index] = element;

        //continue to copy elements into a new array
        int amountElementsToRead = size - index;
        //read in 'array' from [index] and
        // copy into 'newArray', start by [index+1] and set [amount] of the rest element in 'array'
        System.arraycopy(array, index, newArray, index +1, amountElementsToRead);

        return newArray;
    }

    private void replaceCurrentArrayIntoAnother(Object[] another) {
        //clear the previous array
        clearArrayReferences();

        //set reference into another
        array = another;
    }

    private boolean isEnoughCapacity() {
        return (size + 1) <= capacity;
    }

    private void expandCapacity() {
        if (capacity == Integer.MAX_VALUE) {
            throw new OutOfMemoryError("Array is already full.");
        }

        double newCapacity = (capacity * 1.5);

        int MAX_CAPACITY = Integer.MAX_VALUE;
        if (newCapacity > MAX_CAPACITY) {
            setHugeCapacity();
        } else {
            capacity = (int) newCapacity;
        }

        array = Arrays.copyOf(array, capacity);
    }

    private void setHugeCapacity() {
        capacity = Integer.MAX_VALUE;
    }

    @Override
    public T set(int index, T element) {
        if (isOutOfPossibleRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        @SuppressWarnings("unchecked")
        T previous = (T) array[index];
        array[index] = element;

        return previous;
    }

    @Override
    public T get(int index) {
        if (isOutOfPossibleRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        @SuppressWarnings("unchecked")
        T element = (T) array[index];
        return element;
    }

    private boolean isOutOfPossibleRange(int index) {
        return index < 0 || size <= index;
    }

    @Override
    public T remove(int index) {
        if (isOutOfPossibleRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        @SuppressWarnings("unchecked")
        T removed = (T) array[index];

        Object[] newArray = createArrayWithoutIndexedElement(index);
        replaceCurrentArrayIntoAnother(newArray);

        --size;

        return removed;
    }

    private Object[] createArrayWithoutIndexedElement(int index) {
        Object[] newArray = new Object[size-1];

        System.arraycopy(array, 0, newArray, 0, index);

        int elementsToRead = size-index-1;
        System.arraycopy(array, index+1, newArray, index, elementsToRead);

        return newArray;
    }

    @Override
    public boolean remove(T element) {
        int index = indexOf(element);

        if( index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if(array[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(T element) {
        for (int i = size-1; i > 0; i--) {
            if(array[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void clear() {
        clearArrayReferences();

        capacity = DEFAULT_CAPACITY;
        size = 0;

        array = new Object[DEFAULT_CAPACITY];
    }

    private void clearArrayReferences() {
        for (int i = 0; i < size; ++i) {
            array[i] = null;
        }
    }

}
