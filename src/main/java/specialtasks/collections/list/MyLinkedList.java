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

        private int data;
        private Node previous;
        private Node next;

        public Node() {}
        public Node(int data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
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

    public boolean add(int element) {
        Node node = new Node();
        node.setData(element);
        size++;

        //when the list is empty
        if(first == null) {
            first = node;
            last = node;
        } else {//when we have just add to end of the list
            node.setPrevious(last);
            last.setNext(node);
            last = node;
        }

        return true;
    }

    public void add(int index, int element) {
        //check: if passed index is in possible range
        if(index < 0 || size <= index) {
            throw  new RuntimeException("index points to not exist element");
        }

        //create another one Node for going through the list
        Node next;
        size++;

        //find the best way to find the element
        int middle = size / 2;
        //when the element is at the first half of list
        if(index <= middle) {
            //begin with the first element
            next = first;

            //searching the element which is under the index
            for (int i = 0; i != index ; i++) {
                next = next.getNext();
            }
        }
        //when the element is at the second half of list
        else {
            //begin with the first element
            //and go to back
            next = last;

            //searching the element which is under the index
            for (int i = size-1; i != index ; i--) {
                next = next.getPrevious();
            }

        }

        Node previous = next.getPrevious();
        Node node = new Node();
        node.setData(element);

        //insert a new node to the list
        previous.setNext(node);
        node.setNext(next);

        next.setPrevious(node);
        node.setPrevious(previous);

    }

    public int get(int index) {
        //check: if passed index is in possible range
        if(index < 0 || size <= index) {
            throw  new RuntimeException("index points to not exist element");
        }

        //create another one Node for going through the list
        Node node;

        //find the best way to find the element
        int middle = size / 2;
        //when the element is at the first half of list
        if(index <= middle) {
            //begin with the first element
            node = first;

            //searching the element which is under the index
            for (int i = 0; i != index ; i++) {
                node = node.getNext();
            }
        }
        //when the element is at the second half of list
        else {
            //begin with the first element
            //and go to back
            node = last;

            //searching the element which is under the index
            for (int i = size-1; i != index ; i--) {
                node = node.getPrevious();
            }

        }

        //return information which that node stores
        return node.getData();
    }

    public int set(int index, int element) {
        //check: if passed index is in possible range
        if(index < 0 || size <= index) {
            throw  new RuntimeException("index points to not exist element");
        }

        //create another one Node for going through the list
        Node node;

        //find the best way to find the element
        int middle = size / 2;
        //when the element is at the first half of list
        if(index <= middle) {
            //begin with the first element
            node = first;

            //searching the element which is under the index
            for (int i = 0; i != index ; i++) {
                node = node.getNext();
            }
        }
        //when the element is at the second half of list
        else {
            //begin with the first element
            //and go to back
            node = last;

            //searching the element which is under the index
            for (int i = size-1; i != index ; i--) {
                node = node.getPrevious();
            }

        }

        node.setData(element);

        //return information which that node stores
        return node.getData();
    }

    public int remove(int index) {
        //check: if the list is empty
        if(size == 0 || first == null || last == null) {
            throw new RuntimeException("The is empty.");
        }
        //check: if passed index is in possible range
        if(index < 0 || size <= index) {
            throw  new RuntimeException("index points to not exist element.");
        }

        //when the only one element in list has to be removed
        if(index == 0 && first == last) {
            first = null;
            last  = null;

            size = 0;
        }

        int element;

        //when it is needed to remove from list the first element
        if(index == 0) {
            element = first.getData();
            first.setNext(first.getNext());
            first.setPrevious(null);
            size--;
            return element;//everything is done, than go out
        }



        //two pointers are needed for having the previous node
        // when the current is wanted
        Node node = first;

        //find the best way to find the element
        int middle = size / 2;
        //when the element is at the first half of list
        if(index <= middle) {
            //begin with the first element
            node = first;

            //searching the element which is under the index
            for (int i = 0; i != index ; i++) {
                node = node.getNext();
            }
        }
        //when the element is at the second half of list
        else {
            //begin with the first element
            //and go to back
            node = last;

            //searching the element which is under the index
            for (int i = size-1; i != index ; i--) {
                node = node.getPrevious();
            }

        }


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

}