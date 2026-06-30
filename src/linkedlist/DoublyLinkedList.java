package linkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    // Inner static class
    private static class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    // [CHANGED] now also links the new node's prev and fixes old head's prev
    public void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    // [CHANGED] sets n.prev = tail before relinking tail.next
    public void insertLast(int data) {
        if (tail == null) {
            insertFirst(data);
            return;
        }

        Node n = new Node(data);
        n.prev = tail;
        tail.next = n;
        tail = n;

        size++;
    }

    // [CHANGED] cosmetic only: prints "NULL <-" prefix to show it's a doubly-linked list
    public void display() {
        Node temp = head;

        System.out.print("NULL <- ");
        while (temp != null) {
            System.out.print(temp.getValue() + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // [NEW] not present in singly-linked version; walks backward using prev pointers
    public void displayReverse() {
        Node temp = tail;

        System.out.print("NULL <- ");
        while (temp != null) {
            System.out.print(temp.getValue() + " -> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    // [CHANGED] gets node at index directly (not index-1) and relinks both prev and next
    public void insertAtPos(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            insertFirst(data);
            return;
        }

        if (index == size) {
            insertLast(data);
            return;
        }

        Node curr = get(index);
        Node prev = curr.prev;

        Node node = new Node(data, curr, prev);
        prev.next = node;
        curr.prev = node;

        size++;
    }

    // [CHANGED] sets new head's prev to null instead of just relying on tail check
    public int deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        int val = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }

        size--;
        return val;
    }

    // [CHANGED] uses tail.prev directly instead of get(size - 2) traversal
    public int deleteLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }

        if (size == 1) {
            return deleteFirst();
        }

        int val = tail.value;
        tail = tail.prev;
        tail.next = null;

        size--;
        return val;
    }

    // [CHANGED] walks from head or tail, whichever side is closer to index
    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node node;

        // optimization: walk from whichever end is closer
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
    }

    // [CHANGED] relinks curr.prev.next and curr.next.prev directly, no need for "prev of target" lookup
    public int delete(int indx) {
        if (indx < 0 || indx >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (indx == 0) {
            return deleteFirst();
        }

        if (indx == size - 1) {
            return deleteLast();
        }

        Node curr = get(indx);
        int val = curr.value;

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        size--;
        return val;
    }

    public Node find(int val) {
        Node node = head;

        while (node != null) {
            if (node.value == val) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    // [CHANGED] simpler than singly-linked version: just swaps next/prev on each node, then swaps head/tail
    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }

        Node curr = head;
        Node temp;

        // swap next and prev for every node
        while (curr != null) {
            temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            curr = temp;
        }

        // swap head and tail
        temp = head;
        head = tail;
        tail = temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList ls = new DoublyLinkedList();
        ls.insertFirst(10);
        ls.insertLast(20);
        ls.insertLast(30);
        ls.insertLast(40);
        ls.insertLast(50);
        ls.display();
        ls.displayReverse();
        ls.reverseIterate();
        ls.display();
    }
}