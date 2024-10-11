package hw05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {

    }
}

interface BinTree<T extends Comparable<T>> {
    boolean isLeaf();

    boolean contains(T item);
    BinTree<T> add(T item);
    BinTree<T> remove(T item);

    BinTree<T> left();
    T data();
    BinTree<T> right();


}

record BinBranch<T extends Comparable<T>>(BinTree<T> left, T data, BinTree<T> right) implements BinTree<T> {

    @Override
    public boolean isLeaf() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isLeaf'");
    }

    @Override
    public boolean contains(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public BinTree<T> add(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public BinTree<T> remove(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

}

record BinLeaf<T extends Comparable<T>>() implements BinTree<T> {

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public BinTree<T> add(T item) {
        return new BinBranch<T>(this, item, this);
    }

    @Override
    public BinTree<T> remove(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public BinTree<T> left() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'left'");
    }

    @Override
    public T data() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'data'");
    }

    @Override
    public BinTree<T> right() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'right'");
    }

}