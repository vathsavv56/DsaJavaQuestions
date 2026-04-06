package linkedlist;

public class LinkedList {
    private Node tail;
    private Node head;
    private int size;

    public LinkedList(){
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

    public void insertFirst(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    public void display(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.getValue() + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void insertLast(int data){
        if(tail == null){
            insertFirst(data);
            return;
        }

        Node n = new Node(data);
        tail.next = n;
        tail = n;
        size++;
    }

    public void insertLastWithoutTail(int data){
        Node n = new Node(data);

        if (head == null){
            head = tail = n;
            size++;
            return;
        }


        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = n;
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

    public int deleteFirst(){
        if (head == null){
            throw new IllegalStateException("List is empty");
        }


        int val = head.value;
        head = head.next;

        if (head == null){
            tail = null;
        }

        size--;
        return val;
    }

    public int deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;

        tail = secondLast;
        tail.next = null;

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

    public Node find(int val){
        Node node = head;

        while (node != null){
            if(node.value == val){
                return node;
            }
            node = node.next;
        }

        return null;
    }
    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        Node oldHead = head; // will become tail

        while (currNode != null) {
            Node nextNode = currNode.next;

            currNode.next = prevNode; // reverse link

            // move forward
            prevNode = currNode;
            currNode = nextNode;
        }

        // fix head and tail AFTER loop
        oldHead.next = null; // new tail should point to null
        head = prevNode;     // new head
        tail = oldHead;      // new tail
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
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