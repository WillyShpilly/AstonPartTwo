package One;

import java.util.Map;
import java.util.HashMap;

public class CustomHashSet<T> {

    private static final Object OBJECT = new Object();

    private final Map<T, Object> values = new HashMap<>();


    public boolean add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("⚠⚠⚠ Ахтунг ⚠⚠⚠⚠");
        }
        return values.put(value, OBJECT) == null;
    }

    public boolean remove(T value) {
        if (value == null) {
            throw new IllegalArgumentException("⚠⚠⚠ Ахтунг ⚠⚠⚠");
        }
        return values.remove(value) != null;
    }
}

