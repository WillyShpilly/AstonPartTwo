package One;

import java.util.Collection;

public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] values;

    private int size;

    private int capacity;

    public MyArrayList() {
        capacity = DEFAULT_CAPACITY;
        this.values = new Object[DEFAULT_CAPACITY];
    }

    public void add(T value) {
        ensureCapacity(size + 1);
        values[size++] = value;
    }

    public T get(int index) {
        return (T)values[index];
    }

    public void addAll(Collection<? extends T> collection) {
        ensureCapacity(size + collection.size());
        collection.forEach(this::add);
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        values[--size] = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Некорректный индекс");
        }
    }

    private void grow() {
        capacity *= 2;
        Object[] arrayNew = new Object[capacity];
        for (int i = 0; i < size; i++) {
            arrayNew[i] = values[i];
        }
        values = arrayNew;
    }

    private void ensureCapacity(int index) {
        if (index < 0 || index >= capacity) {
            grow();
        }
    }

}
