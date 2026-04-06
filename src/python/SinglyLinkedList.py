class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
    def getValue(self):
        print(self.value)

    def getNext(self):
        print(self.next)

class SingleLinkedList:
    
    def __init__(self):
        self.head = None


    def display(self):
        current = self.head
        while current:
            print(current.value, end='->')
            current = current.next
            if current is None:
                 print('None', end='')
        print()

    def reversePrint(self):
        reverseList = []
        current = self.head

        while current:
            reverseList.append(current.value)
            current = current.next
        
        print(reverseList[::-1])
    def reverse(self):
        prev = None
        curr = self.head

        while(curr):
            next = curr.next
            curr.next = prev
            prev = curr 
            curr = next 
        self.head = prev


    def insertFirst(self , data):
        nb = Node(data)
        nb.next = self.head
        self.head = nb

    def insertEnd(self , data):
        current = self.head
        while current.next:
            current = current.next
        ne = Node(data)
        current.next = ne
    
    def insertAtPos(self , data , pos):
        temp = self.head
        indx = 0
        while temp.next:
            temp = temp.next
            indx += 1

            if indx == pos - 1:
                n = Node(data)
                n.next = temp.next
                temp.next = n

    def deleteFirst(self):
        self.head = self.head.next  
        
    def deleteLast(self):
        prev = self.head
        curr = self.head.next

        while curr.next:
            curr = curr.next
            prev = prev.next
        
        prev.next = None
    
    
        
                


        
                
            




n1 = Node(1)
n2 = Node(2)
n1.next = n2
n3 = Node(3)
n2.next = n3
linked_list = SingleLinkedList()
linked_list.head = n1
linked_list.display()
# linked_list.reversePrint()
linked_list.reverse()
linked_list.display()
linked_list.insertFirst(5)
linked_list.display()
linked_list.insertEnd(40)
linked_list.display()
linked_list.insertAtPos(32, 2)
# linked_list.updateAtPos(67 , 3)
linked_list.display()
linked_list.deleteFirst()
linked_list.display()
linked_list.deleteLast()
linked_list.display()