package specialtasks.collections.list;

public interface MyList {
    int size();

    boolean add(String element);
    void add(int index, String element);
    String set(int index, String element);

    String get(int index);

    String remove(int index);
    boolean remove(String element);

    boolean contains(String element);

    int indexOf(String element);
    int lastIndexOf(String element);

    void clear();

}
