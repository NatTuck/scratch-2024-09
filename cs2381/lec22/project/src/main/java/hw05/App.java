package hw05;

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

    BinTree<T> union(BinTree<T> that);
    BinTree<T> intersect(BinTree<T> that);
}

record BinBranch<T extends Comparable<T>>(BinTree<T> left, T data, BinTree<T> right) implements BinTree<T> {

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean contains(T item) {
        var cmp = item.compareTo(data());
        if (cmp == 0) {
            return true;
        }

        if (cmp < 0) {
            return left().contains(item);
        }
        else {
            return right().contains(item);
        }
    }

    @Override
    public BinTree<T> add(T item) {
        var cmp = item.compareTo(data());
        if (cmp == 0) {
            return this;
        }

        if (cmp < 0) {
            var newLeftSubTree = left().add(item);
            if (newLeftSubTree == left()) {
                return this;
            }
            else {
                return new BinBranch<>(newLeftSubTree, data(), right());
            }
        }
        else {
            var newRightSubTree = right().add(item);
            if (newRightSubTree == right()) {
                return this;
            }
            else {
                return new BinBranch<>(left(), data(), newRightSubTree);
            }
        }
    }

    @Override
    public BinTree<T> remove(T item) {
        var cmp = item.compareTo(data());
        if (cmp == 0) {
            if (this.left().isLeaf()) {
                return this.right();
            }

            if (this.right().isLeaf()) {
                return this.left();
            }

            var newData = left().data();
            var newLeft = left().left();
            var newRight = right().union(left.right());
            return new BinBranch<>(newLeft, newData, newRight);
        }

        if (cmp < 0) {
            var newLeftSubTree = left().remove(item);
            if (newLeftSubTree == left()) {
                return this;
            }
            else {
                return new BinBranch<>(newLeftSubTree, data(), right());
            }
        }
        else {
            var newRightSubTree = right().remove(item);
            if (newRightSubTree == right()) {
                return this;
            }
            else {
                return new BinBranch<>(left(), data(), newRightSubTree);
            }
        }
    }

    @Override
    public BinTree<T> union(BinTree<T> that) {
        if (that.isLeaf()) {
            return this;
        }

        var yy = this.add(that.data());
        yy = yy.union(that.left());
        yy = yy.union(that.right());
        return yy;
    }

    @Override
    public BinTree<T> intersect(BinTree<T> that) {
        if (that.isLeaf()) {
            return that;
        }

        var item = this.data();
        BinTree<T> yy = new BinLeaf<T>();
        if (that.contains(item)) {
            yy = yy.add(item);
        }
        var leftIntersect = this.left().intersect(that);
        var rightIntersect = this.right().intersect(that);
        return yy.union(leftIntersect).union(rightIntersect);
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
        // TODO: May unbalance tree, should fix.
        return new BinBranch<T>(this, item, this);
    }

    @Override
    public BinTree<T> remove(T item) {
        return this;
    }

    @Override
    public BinTree<T> left() {
        throw new UnsupportedOperationException("Empty tree has no 'left'");
    }

    @Override
    public T data() {
        throw new UnsupportedOperationException("Empty tree has no 'data'");
    }

    @Override
    public BinTree<T> right() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Empty tree has no 'right'");
    }

    @Override
    public BinTree<T> union(BinTree<T> that) {
        return that;
    }

    @Override
    public BinTree<T> intersect(BinTree<T> that) {
        return this;
    }

}