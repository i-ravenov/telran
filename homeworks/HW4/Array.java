package telran.util;

import java.util.Arrays;

public class Array {
    private Object[] array;
    private int size = 0;

    public Array(int capacity) {
        array = new Object[capacity];
    }

    public Array() {
        this(16);
    }

    public void add(Object obj) {
        if (size == array.length) {
            allocateArray();
        }
        array[size++] = obj;
    }

    private void allocateArray() {
        array = Arrays.copyOf(array, array.length * 2);

    }

    public Object get(int index) {
        Object res = null;
        if (index >= 0 && index < size) {
            res = array[index];
        }
        return res;
    }

    public int size() {
        return size;
    }

    /**
     * adds an object at a specified index
     * 
     * @param index
     * @param obj
     * @return true if index value in the range [0 - size] (size included) otherwise
     *         false
     */
    public boolean add(int index, Object obj) {
        if (index >= 0 && index <= size) {
            if (size == index) {
                allocateArray();
            }
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = obj;
            size++;
            return true;
        }
        // TODO
        return false;
    }

    /**
     * removes the object at a specified index
     * 
     * @param index
     * @return reference to the removed object or null in the case of wrong index
     */
    public Object remove(int index) {
        Object res = null;
        if (index >= 0 && index < size) {
            res = array[index];
            System.arraycopy(array, index + 1, array, index, size - index);
            size--;
        }
        return res;
    }

    /**
     * sets new object at a specified index
     * 
     * @param index
     * @param obj
     * @return old reference to the object or null in the case of wrong index value
     */
    public Object set(int index, Object obj) {
        Object res = null;
        if(index>=0 && index<size) {
            res = array[index];
            array[index] = obj;
        }
        return res;
    }
}