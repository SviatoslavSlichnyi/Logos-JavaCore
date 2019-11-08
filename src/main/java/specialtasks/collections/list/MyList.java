package specialtasks.collections.list;

public interface MyList {
    int size();

    boolean add(int element);
    void add(int index, int element);
    int get(int index);
    int set(int index, int element);
    int remove(int index);
    void clear();

}
