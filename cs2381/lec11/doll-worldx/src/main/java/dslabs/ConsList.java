package dslabs;

interface ConsList<T> {
    boolean isEmpty();
    int length();
    T first();
    ConsList<T> rest();
}

record ConsCell<T>(T first, ConsList<T> rest) implements ConsList<T> {
    // record auto-generates first() accessor method.
    // record auto-generates rest() accessor method.

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int length() {
        return 1 + rest.length();
    }
}

record ConsEmpty<T>() implements ConsList<T> {

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public T first() {
        throw new UnsupportedOperationException("empty list");
    }

    @Override
    public ConsList<T> rest() {
        throw new UnsupportedOperationException("empty list");
    }
}