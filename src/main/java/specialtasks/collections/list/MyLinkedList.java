package specialtasks.collections.list;

public class MyLinkedList implements MyList {

    //pointer into the first node in list
    private Node first;
    private Node last;
    private int size;


    //Node in linked list which has to contain two information
    //the first ("data") store data
    //the second ("next") store reference to the next node in linked list
    private static class Node {

        private String data;
        private Node previous;
        private Node next;

        public Node() {}
        public Node(String data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {

        return first == null && last == null && size == 0;

    }

    public boolean add(String element) {

        Node node = new Node();
        node.setData(element);

        if(isEmpty()) {

            addElementToBegin(node);

        } else {

            addElementToEnd(node);

        }

        size++;

        return true;
    }

    private void addElementToBegin(Node node) {

        first = node;
        last = node;

    }

    private void addElementToEnd(Node node) {

        node.setPrevious(last);
        last.setNext(node);
        last = node;

    }

    public void add(int index, String element) {

        //simple addition to the end of list
        if(index == size) {

            add(element);
            return;

        }

        //check: if passed index is in possible range
        if(isOutOfRange(index)) {
            throw  new IndexOutOfBoundsException();
        }

        Node node = new Node();
        node.setData(element);


        if(index == 0) {

            insertElementAtBegin(node);

        }
        else {

            insertElementInMiddle(index, node);

        }

        size++;

    }

    private void insertElementAtBegin(Node node) {

        node.setPrevious(null);
        node.setNext(first);

        first = node;

    }

    private void insertElementInMiddle(int index, Node node) {

        //create another one Node for going through the list
        Node next = findNode(index);

        Node previous = next.getPrevious();


        //insert a new node to the list
        previous.setNext(node);
        node.setNext(next);

        node.setPrevious(previous);
        next.setPrevious(node);

    }

    public String get(int index) {

        //check: if passed index is in possible range
        if(isOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node node = findNode(index);

        return node.getData();

    }

    public String set(int index, String element) {
        //check: if passed index is in possible range
        if(isOutOfRange(index)) {
            throw  new IndexOutOfBoundsException();
        }

        Node node = findNode(index);

        String previousValue = node.getData();

        node.setData(element);

        //return information which that node stores
        return previousValue;
    }

    public String remove(int index) {
        //check: if the list is empty
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        //check: if passed index is in possible range
        if(isOutOfRange(index)) {
            throw  new IndexOutOfBoundsException();
        }

        //when the only one element in list has to be removed
        if(index == 0 && first == last) {
            first = null;
            last  = null;

            size = 0;
        }

        String element;

        //when it is needed to remove from list the first element
        if(index == 0) {
            element = first.getData();
            Node next = first.getNext();
            first.setNext(null);
            first.setPrevious(null);
            first = next;
            first.setPrevious(null);

            size--;
            return element;//everything is done, than go out
        }



        //two pointers are needed for having the previous node
        // when the current is wanted
        Node node = findNode(index);

        element = node.getData();
        //if it happened that element is not the first
        //it's is going on simple search node by node
        //which means that the element will be removed
        //so size surly will be smaller by one
        size--;

        //when the current element which has to be removed is the last el. in the list
        if(last == node) {
            Node previous = last.getPrevious();
            last.setPrevious(null);
            last = previous;
            last.setNext(null);

            return element;
        }

        //changing the previous node's "next" reference to current's next reference
        //in this way the wanted element will be removed from linked list
        Node previous = node.getPrevious();
        Node next = node.getNext();

        node.setPrevious(null);
        node.setNext(null);

        previous.setNext(next);
        next.setPrevious(previous);

        return element;
    }

    public void clear() {

        //two pointer for deleting references between nodes
        Node forward, backward;

        //do cleaning from both sides
        while(size != 0) {

            forward = first.getNext();
            first.setNext(null);
            first = forward;

            backward = last.getPrevious();
            last.setPrevious(null);
            last = backward;

            size--;

        }

    }

    private Node findNode(int index) {

        if(isOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node node;

        //find the best way to find the element
        int middle = size / 2;

        //when the element is at the first half of list
        if(index <= middle) {
            node = startSearchFromBegin(index);
        }

        //when the element is at the second half of list
        else {
            node = startSearchFromEnd(index);
        }

        return node;
    }

    //check: if passed index is in possible range
    private boolean isOutOfRange(int index) {
        return index < 0 || size <= index;
    }

    //searching the element which is at the first part of list
    private Node startSearchFromBegin(int index) {

        Node node = first;

        for (int i = 0; i != index ; i++) {
            node = node.getNext();
        }

        return node;
    }

    //searching the element which is at the second part of list
    private Node startSearchFromEnd(int index) {

        Node node = last;

        //searching the element which is under the index
        for (int i = size-1; i != index ; i--) {
            node = node.getPrevious();
        }

        return node;
    }

}