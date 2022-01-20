package f2;

import java.util.Arrays;

public class IntList {
    private int size;
    private int[] array;
    IntList(int initialCapacity) {
        array = new int[initialCapacity];
        size = 0;
    }

    int add(int element) {
        return add(size, element);
    }

    /**
     * Inserts into index
     * @param index
     * @param element
     * @return
     */
    int add(int index, int element) {
        if(size == array.length)
            reallocate(array.length*2);
        // push forward elements if not added in the end
        if (index != size) {
            // backlänges
            for (int i = size; i != index; i--) {
                array[i] = array[i-1];
            }
        }
        size++;
        return array[index] = element;
    }

    int get(int index) {
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return array[index];
    }

    int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element)
                return i;
        }
        return -1;
    }

    int remove(int index) {
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        var removed = array[index];
        for (int i = index; i <= size; i++) {
            array[i] = array[i+1];
        }
        size--;
        return removed;
    }

    int set(int index, int element) {
        return array[index] = element;
    }

    int size() {
        return size;
    }

    private void reallocate(int newCapacity) {
        array = Arrays.copyOf(array, newCapacity);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size-1) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}
