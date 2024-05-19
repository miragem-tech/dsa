public class LinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        newNode.prev = this.tail;

        if (this.head != null) {
            this.head.prev = newNode;
        }

        this.head = newNode;

        if (size == 0) {
            this.tail = this.head;
        } else {
            this.tail.next = this.head;
        }

        this.size++;
    }

    public boolean delete(Node node) {
        if (size == 0) {
            return false;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node == this.head) {
            this.head = this.head.next;
        }

        if (node == this.tail) {
            this.tail = this.tail.prev;
        }

        if (size == 1 && this.head == node && this.tail == node) {
            this.head = null;
            this.tail = null;
        }

        this.size--;

        return true;
    }

    public Node search(int data) {
        Node current = this.head;

        while (current != null) {
            if (current.data == data) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int size() {
        return size;
    }
}
