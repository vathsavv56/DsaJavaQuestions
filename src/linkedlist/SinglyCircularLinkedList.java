package linkedlist;

public class SinglyCircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyCircularLinkedList(){
        this.size = 0;
    }

    // Inner static class
    private static class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value , Node next){
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    // [CHANGED] when list is non-empty, new node also gets relinked as the
    // wrap-around target of tail (tail.next must always point to head)
    public void insertFirst(int data){
        Node node = new Node(data);

        if (head == null){
            head = tail = node;
            node.next = node; // single node points to itself
        } else {
            node.next = head;
            head = node;
            tail.next = head; // keep the circle closed
        }

        size++;
    }

    // [CHANGED] uses do-while instead of while, since head == head is true
    // at the start — a plain while loop would never execute
    public void display(){
        if (head == null){
            System.out.println("Empty list");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.getValue() + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head: " + head.getValue() + ")");
    }

    public void insertLast(int data){
        if (tail == null){
            insertFirst(data);
            return;
        }

        Node n = new Node(data);
        n.next = head; // new tail wraps to head
        tail.next = n;
        tail = n;
        size++;
    }

    public void insertAtPos(int data , int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            insertFirst(data);
            return;
        }

        if (index == size){
            insertLast(data);
            return;
        }

        Node prev = get(index - 1);
        prev.next = new Node(data , prev.next);

        size++;
    }

    // [CHANGED] must explicitly re-wrap tail.next to the new head;
    // a singly list can't fix this from the tail side automatically
    public int deleteFirst(){
        if (head == null){
            throw new IllegalStateException("List is empty");
        }

        int val = head.value;

        if (head == tail){ // only one node
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head; // close the circle on the new head
        }

        size--;
        return val;
    }

    // [CHANGED] re-wraps the new tail's next to head instead of setting null
    public int deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;

        tail = secondLast;
        tail.next = head; // keep the circle closed

        size--;
        return val;
    }

    public Node get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public int delete(int indx){
        if (indx < 0 || indx >= size){
            throw new IndexOutOfBoundsException();
        }

        if (indx == 0){
            return deleteFirst();
        }

        if(indx == size - 1){
            return deleteLast();
        }

        Node prev = get(indx - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;

        size--;
        return val;
    }

    // [CHANGED] do-while traversal so it doesn't loop forever / never start
    public Node find(int val){
        if (head == null) return null;

        Node node = head;
        do {
            if(node.value == val){
                return node;
            }
            node = node.next;
        } while (node != head);

        return null;
    }

    // [CHANGED] no null sentinel exists in a circular list, so we can't
    // detect "end of list" by checking for null. Instead we loop exactly
    // `size` times, starting prevNode at tail (the node logically "before"
    // head), and reconnect head/tail at the end. The circularity is
    // preserved automatically because every node's next still points
    // somewhere in the ring after the swap.
    public void reverseIterate() {
        if (head == null || head == tail) {
            return;
        }

        Node prevNode = tail; // node "before" head in a circular sense
        Node currNode = head;
        Node oldHead = head;

        for (int i = 0; i < size; i++) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }

        head = prevNode; // old tail becomes new head
        tail = oldHead;  // old head becomes new tail
    }

    public static void main(String[] args) {
        SinglyCircularLinkedList ls = new SinglyCircularLinkedList();
        ls.insertFirst(10);
        ls.insertLast(20);
        ls.insertLast(30);
        ls.insertLast(40);
        ls.insertLast(50);
        ls.display();
        ls.reverseIterate();
        ls.display();
    }
}