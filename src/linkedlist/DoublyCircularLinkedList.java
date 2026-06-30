package linkedlist;

public class DoublyCircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyCircularLinkedList() {
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

    // [CHANGED] besides linking next/prev for the new node, both head.prev
    // and tail.next have to be re-pointed to keep the ring closed on both sides
    public void insertFirst(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = tail = node;
            node.next = node; // single node wraps to itself both ways
            node.prev = node;
        } else {
            node.next = head;
            node.prev = tail;

            head.prev = node;
            tail.next = node;

            head = node;
        }

        size++;
    }

    // [CHANGED] new tail must link back to head on both next and prev,
    // and head.prev must be updated to the new tail
    public void insertLast(int data) {
        if (tail == null) {
            insertFirst(data);
            return;
        }

        Node n = new Node(data);
        n.prev = tail;
        n.next = head;

        tail.next = n;
        head.prev = n;

        tail = n;
        size++;
    }

    // [CHANGED] do-while traversal — a circular list has no null terminator
    public void display() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.getValue() + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head: " + head.getValue() + ")");
    }

    // [CHANGED] walks backward from tail using prev, stopping when we wrap
    // back to tail instead of hitting null
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Empty list");
            return;
        }

        Node temp = tail;
        do {
            System.out.print(temp.getValue() + " <-> ");
            temp = temp.prev;
        } while (temp != tail);
        System.out.println("(tail: " + tail.getValue() + ")");
    }

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

    // [CHANGED] re-wraps both head.prev and tail.next to the new head,
    // since deleting the head in a circular list breaks the ring on two sides
    public int deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        Node oldHead = head;
        int val = oldHead.value;

        if (head == tail) { // only one node
            head = tail = null;
        } else {
            head = oldHead.next;
            head.prev = tail;
            tail.next = head;
        }

        oldHead.next = null;
        oldHead.prev = null;

        size--;
        return val;
    }

    // [CHANGED] re-wraps tail.next and head.prev to the new tail
    public int deleteLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }

        if (size == 1) {
            return deleteFirst();
        }

        Node oldTail = tail;
        int val = oldTail.value;

        tail = oldTail.prev;
        tail.next = head;
        head.prev = tail;

        oldTail.prev = null;
        oldTail.next = null;

        size--;
        return val;
    }

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

    // [CHANGED] do-while traversal so it doesn't loop forever / never start
    public Node find(int val) {
        if (head == null) return null;

        Node node = head;
        do {
            if (node.value == val) {
                return node;
            }
            node = node.next;
        } while (node != head);

        return null;
    }

    // [CHANGED] same next/prev-swap trick as the linear doubly list, but
    // looped exactly `size` times instead of stopping at a null curr —
    // circularity is preserved automatically since we only swap existing
    // references, never introduce or remove a null
    public void reverseIterate() {
        if (head == null || head == tail) {
            return;
        }

        Node curr = head;
        Node temp;

        for (int i = 0; i < size; i++) {
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
        DoublyCircularLinkedList ls = new DoublyCircularLinkedList();
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