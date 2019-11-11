package specialtasks.collections.list;

public interface MyList {
    int size();

    boolean add(String element);
    void add(int index, String element);
    String get(int index);
    String set(int index, String element);
    String remove(int index);
    void clear();

}
