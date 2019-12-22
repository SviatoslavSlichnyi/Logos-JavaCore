package specialtasks.collections.list;

public interface MyList<T> {
    int size();

    boolean add(T element);
    void add(int index, T element);
    T set(int index, T element);

    T get(int index);

    T remove(int index);
    boolean remove(T element);

    boolean contains(T element);

    int indexOf(T element);
    int lastIndexOf(T element);

    void clear();

}
