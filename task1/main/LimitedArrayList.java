package homework8.task1;

import java.util.Arrays;

public class LimitedArrayList<E> {
    private int size;
    private int capacity;
    private Object[] array;

    public LimitedArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public boolean add(Object o) throws OverflowingListException {
        if (size >= capacity) {
            throw new OverflowingListException("Not enough place in list");
        }
        array[size++] = o;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public E get(int index) throws OverflowingListException {
        if ((index < size) && (index >= 0)) {
            return (E) array[index];
        }
        throw new OverflowingListException("There is no such an index");
    }

    public Object set(int index, Object element) throws OverflowingListException {
        if ((index < size) && (index >= 0)) {
            Object o = array[index];
            array[index] = element;
            return o;
        }
        throw new OverflowingListException("There is no such an index");
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    lastIndex = i;
                }
            }
            return lastIndex;
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    lastIndex = i;
                }
            }
        }
        return lastIndex;
    }

    private void shiftToLeft(int start) {
        size--;
        if (size <= 0) {
            return;
        }
        if (size != start) {
            System.arraycopy(array, start + 1, array, start, size - start);
        }
        array[size] = null;
    }

    public Object[] getArrWithoutRemovedElement(int ind) {
        if (size < 1) {
            throw new IllegalArgumentException("There aren't elements to remove");
        }
        Object[] arr = new Object[size - 1];
        System.arraycopy(array, 0, arr, 0, ind);
        System.arraycopy(array, ind + 1, arr, ind, size - ind - 1);
        return arr;
    }

    public E remove(int index) throws OverflowingListException {
        Object o;
        if ((index < size) && (index >= 0)) {
            o = get(index);
            shiftToLeft(index);
        } else
            throw new IllegalArgumentException("There is no such an index");
        return (E) o;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
