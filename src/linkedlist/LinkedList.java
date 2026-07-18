package linkedlist;

import java.util.ArrayDeque;

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

    public boolean detectLoop(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return  true;
            }
        }

        return false;
    }


    public Node startOfCycle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
            }

            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }

        }
        return fast;
    }




    public Node getMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
    }


    public boolean isPalindromeStack(Node head){
        ArrayDeque<Integer> stk = new ArrayDeque<>();

        Node temp = head;

        while (temp != null){
            stk.push(temp.value);
            temp = temp.next;
        }

        temp = head;

        while (temp != null){
            if(stk.peek().equals(temp.value)){
                return false;
            }
            temp = temp.next;
            stk.pop();
        }

        return true;

    }

    public Node merge2(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node tail = dummy;   // tail tracks the last node of the merged list

        Node i = head1;
        Node j = head2;

        while (i != null && j != null){
            if(i.value < j.value){
                tail.next = i;
                i = i.next;
            }
            else{
                tail.next = j;
                j = j.next;
            }
            tail = tail.next;   // move tail forward each time
        }

        while (i != null){
            tail.next = i;
            i = i.next;
            tail = tail.next;
        }

        while (j != null){
            tail.next = j;
            j = j.next;
            tail = tail.next;
        }

        return dummy.next;
    }







    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        LinkedList ls2 = new LinkedList();
        ls.insertFirst(10);
        ls.insertLast(20);
        ls.insertLast(30);
        ls.insertLast(40);
        ls.insertLast(50);

        ls2.insertLast(10);
        ls2.insertLast(40);
        ls2.insertLast(50);
        ls2.insertLast(60);
        ls2.insertLast(70);
//        ls.display();
//        ls.reverseIterate();
//        ls.display();
//        System.out.println(ls.getMiddle(ls.head).getValue());
//        System.out.println(ls.detectLoop(ls.head));
//        System.out.println(ls.isPalindromeStack(ls.head));
//
//
//        Node merged = ls.merge2(ls.head,ls2.head);
//
//        while (merged != null){
//            System.out.println(merged.value);
//            merged = merged.next;
//        }
    }
}