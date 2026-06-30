package linkedlist;

public class LL {
    private int size;
    private Node head;
    private Node tail;

    public LL(){
        this.size = 0;
    }


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


    }

    public void insertFirst(int data){
        Node n = new Node(data);
        n.next = head;
        head = n;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void display(){
        Node n = head;

        while (n != null) {
            System.out.print(n.value + " ");

//            if (n == null) {
//                System.out.print("NULL");
//            } else {
//                System.out.print("->");
//            }

            n = n.next;
        }
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

    public void insert(int data , int position){
        if(position < 0 || position > size){
            throw new IndexOutOfBoundsException();
        }
        if(position == 0){
            insertFirst(data);
            return;
        }

        if(position == size){
            insertLast(data);
            return;
        }

        int count = 0;
        Node n = head;
        while (count != position - 1){
            n = n.next;
            count++;
        }

        Node nd = new Node(data);
        nd.next = n.next;
        n.next = nd;

        if(count < position){
            System.out.println("Position out of index");
        }
    }


    public static void main(String[] args) {
        LL ll = new LL();
        ll.insertFirst(10);
        ll.insertFirst(20);
        ll.insertLast(40); // first insertLast not working
        ll.insertLast(30);
        ll.insert(30 , 3);
        ll.display();
    }
}
