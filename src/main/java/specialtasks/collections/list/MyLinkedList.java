package specialtasks.collections.list;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>, Iterable<T> {

    //pointer into the first node in list
    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return null;
    }


    /**
     * Node in linked list which has to contain two information
     * "data" for storing data
     * references (connections) between objects
     */
    private static class Node<T> {

        private T data;
        private Node<T> previous;
        private Node<T> next;

        Node() {
        }

        Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T element) {
        Node<T> node = new Node<T>();
        node.setData(element);

        if (isEmpty()) {
            addFirst(node);
        } else {
            addLast(node);
        }

        size++;
        return true;
    }

    private void addFirst(Node<T> node) {
        first = node;
        last = node;
    }

    private void addLast(Node<T> node) {
        node.setPrevious(last);
        last.setNext(node);
        last = node;
    }

    public void add(int index, T element) {
        //simple addition to the end of list
        if (index == size) {
            add(element);
            return;
        }

        //check: if passed index is in possible range
        if (isOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = new Node<>();
        node.setData(element);

        if (index == 0) {
            insertElementAtBegin(node);
        } else {
            insertElementInMiddle(index, node);
        }

        size++;
    }

    private void insertElementAtBegin(Node<T> node) {
        node.setNext(first);
        first = node;
    }

    private void insertElementInMiddle(int index, Node<T> node) {
        //create another one Node for going through the list
        Node<T> next = findNode(index);
        Node<T> previous = next.getPrevious();

        //insert a new node to the list
        previous.setNext(node);
        node.setNext(next);

        node.setPrevious(previous);
        next.setPrevious(node);
    }

    public T get(int index) {
        //check: if passed index is in possible range
        if (isOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = findNode(index);
        return node.getData();
    }

    public T set(int index, T element) {
        //check: if passed index is in possible range
        if (isOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = findNode(index);
        T previousValue = node.getData();

        node.setData(element);

        //return information which that node stores
        return previousValue;
    }

    public T remove(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        if (isOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        T element;
        //remove the only one element
        if (size == 1) {
            element = first.getData();
            clear();
        }
        //remove first element
        else if (index == 0) {
            element = first.getData();
            removeFirst();
        }
        //remove the last element
        else if (index == (size - 1)) {
            element = last.getData();
            removeLast();
        } else {
            Node<T> node = findNode(index);
            element = node.getData();
            removeMiddle(node);
        }

        if (element == null) {
            throw new RuntimeException("data was not gotten");
        }

        size--;
        return element;
    }

    private void removeFirst() {
        Node<T> next = first.getNext();
        first.setNext(null);
        first.setPrevious(null);
        first = next;
        first.setPrevious(null);
    }

    private void removeMiddle(Node<T> node) {
        if (node == first || node == last) {
            throw new RuntimeException("executed not correct method");
        }
        //changing the previous node's "next" reference to current's next reference
        //in this way the wanted element will be removed from linked list
        Node<T> previous = node.getPrevious();
        Node<T> next = node.getNext();

        node.setPrevious(null);
        node.setNext(null);

        previous.setNext(next);
        next.setPrevious(previous);
    }

    private void removeLast() {
        Node<T> previous = last.getPrevious();
        last.setPrevious(null);
        last = previous;
        last.setNext(null);
    }

    public boolean remove(T element) {
        Node<T> node = findNode(element);

        //if node were not found
        if (node == null) {
            return false;
        }
        else if (node == first) {
            removeFirst();
        }
        else if (node == last) {
            removeLast();
        }
        else {
            removeMiddle(node);
        }

        --size;
        return true;
    }

    public boolean contains(T element) {
        //pointers for the begin and the end of list
        Node<T> forward = first;
        Node<T> backward = last;

        //search element in list
        for (int i = 0, n = size / 2; i <= n; i++) {
            if (forward.getData().equals(element)) {
                return true;
            }
            if (backward.getData().equals(element)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(T element) {
        Node<T> node = first;

        for (int i = 0; node != null; i++) {
            if (node.getData().equals(element)) {
                return i;
            }
            node = node.getNext();
        }

        return -1;
    }

    @Override
    public int lastIndexOf(T element) {
        Node<T> node = last;

        for (int i = size-1; node != null; i--) {
            if (node.getData().equals(element)) {
                return i;
            }
            node = node.getPrevious();
        }

        return -1;
    }

    public void clear() {
        //two pointer for deleting references between nodes
        Node<T> forward, backward;

        //do cleaning from both sides
        while (size != 0) {
            forward = first.getNext();
            first.setNext(null);
            first = forward;

            backward = last.getPrevious();
            last.setPrevious(null);
            last = backward;

            size--;
        }
    }

    private Node<T> findNode(int index) {
        if (isOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node;
        //find the best way to find the element
        int middle = size / 2;

        //when the element is at the first half of list
        if (index <= middle) {
            node = startSearchFromBegin(index);
        }
        //when the element is at the second half of list
        else {
            node = startSearchFromEnd(index);
        }

        return node;
    }

    private Node<T> findNode(T element) {
        //pointers for the begin and the end of list
        Node<T> forward = first;
        Node<T> backward = last;

        //search element in list
        for (int i = 0, n = size / 2; i <= n; i++) {
            if (forward.getData().equals(element)) {
                return forward;
            }
            if (backward.getData().equals(element)) {
                return backward;
            }

            forward = forward.getNext();
            backward = backward.getPrevious();
        }

        return null;
    }

    //check: if passed index is in possible range
    private boolean isOutOfRange(int index) {
        return index < 0 || size <= index;
    }

    //searching the element which is at the first part of list
    private Node<T> startSearchFromBegin(int index) {
        Node<T> node = first;

        for (int i = 0; i != index; i++) {
            node = node.getNext();
        }

        return node;
    }

    //searching the element which is at the second part of list
    private Node<T> startSearchFromEnd(int index) {
        Node<T> node = last;

        //searching the element which is under the index
        for (int i = size - 1; i != index; i--) {
            node = node.getPrevious();
        }

        return node;
    }

}
