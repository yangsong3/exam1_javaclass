class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> aMap = new HashMap<>();

        aMap.put("철수나이", 22);
        aMap.put("영희나이", 23);
        System.out.println(aMap);

        aMap.remove("철수나이");
        System.out.println(aMap);

        aMap.remove("영희나이");
        System.out.println(aMap);

    }
}
// CRUD
class HashMap<K, V> {
    private Object[] keys;
    private Object[] values;
    private int size;

    HashMap() {
        int initSize = 3;
        keys = new Object[initSize];
        values = new Object[initSize];
        size = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < size; i++ ) {
            if ( i != 0 ) {
                sb.append(", ");
            }
            sb.append(keys[i] + " : " + values[i]);
        }
        sb.insert(0, "Map [");
        sb.append("], size : " + size);

        return sb.toString();
    }

    public void remove(K key) {
        int index = getIndexOfKey(key);

        if ( index == -1 ) {
            return;
        }

        for ( int i = index; i < size; i++ ) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }

        size--;
    }

    private boolean isFull() {
        return size == keys.length;
    }

    private void sizeUpArr() {
        Object[] newKeys = new Object[keys.length * 2];

        for ( int i = 0; i < size; i++ ) {
            newKeys[i] = keys[i];
        }

        keys = newKeys;

        Object[] newValues = new Object[values.length * 2];

        for ( int i = 0; i < size; i++ ) {
            newValues[i] = values[i];
        }

        values = newValues;
    }

    private void sizeUpArrIsFull() {
        if ( isFull() ) {
            sizeUpArr();
        }
    }

    public void put(K key, V value) {
        int index = getIndexOfKey(key);

        if ( index != -1 ) {
            values[index] = value;
            return;
        }

        sizeUpArrIsFull();

        keys[size] = key;
        values[size] = value;
        size++;
    }

    private int getIndexOfKey(Object key) {
        for ( int i = 0; i < size; i++ ) {
            if ( keys[i].equals(key) ) {
                return i;
            }
        }

        return -1;
    }

    public V get(Object key) {
        int index = getIndexOfKey(key);

        if ( index == -1 ) {
            return null;
        }

        return (V) values[index];
    }
}