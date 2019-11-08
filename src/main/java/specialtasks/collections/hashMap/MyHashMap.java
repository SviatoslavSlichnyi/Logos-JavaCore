package specialtasks.collections.hashMap;

public class MyHashMap {


    private final int TABLE_SIZE = 30;
    private Node[] table;


    public MyHashMap() {
        //allocate memory for nodes
        table = new Node[TABLE_SIZE];
        //fill each table element with empty LinkedList which contains Nodes
    }

    private static class Node {
        private MyDate key;
        private String value;
        private Node next;

        public Node(){}
        public Node(MyDate key, String value) {
            this.key = key;
            this.value = value;
        }
        public Node(MyDate key, String value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public MyDate getKey() {
            return key;
        }

        public void setKey(MyDate key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    //adding element to map by ky
    public void put(MyDate key, String name) {
        //the first step is to take hash code from key
        int keyValue = key.hashCode() % TABLE_SIZE;

        //than create a node
        Node node = new Node(key, name);
        //and store this store information (key and name together)
        node.setNext(table[keyValue]);
        table[keyValue] = node;
    }

    //getting element from map by key
    public String get(MyDate key) {
        //the first step is to take hash code
        int keyValue = key.hashCode() % TABLE_SIZE;

        //the second step is to take exact key and name from list
        // with the same key from list
        //going through the list by iterator
        Node node = table[keyValue];

        //search key
        while(node != null) {
            if(node.getKey().equals(key))
                return node.getValue();

            node = node.getNext();
        }

        //if search were finished without success
        //in this case return value null
        return null;
    }

}
