from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
    def insert(self,data):
        if self.data:
            if data < self.data:
                if self.left is None:
                    self.left = Node(data)
                else:
                    self.left.insert(data)
            else:
                if self.right is None:
                    self.right = Node(data)
                else:
                    self.right.insert(data)
def inorder(root):
    if root:
        inorder(root.left)
        print(root.data , end=" ")
        inorder(root.right)

def preorder(root):
    if root:
        print(root.data , end=" ")
        preorder(root.left)
        preorder(root.right)

def postorder(root):
    if root:
        postorder(root.left)
        postorder(root.right)
        print(root.data , end=" ")
    
def level(root):
    if not root:
        return None
    q = deque([root])
    while q:
        current = q.popleft()
        print(current.data, end=" ")
        if current.left:
            q.append(current.left)
        if current.right:
            q.append(current.right)

def size(root):
    if root is None:
        return 0
    else:
        return size(root.left) + 1 + size(root.right)

def min(root):
    while(root.left):
        root = root.left
    print(root.data)

def max(root):
    while(root.right):
        root = root.right
    print(root.data)

def search(root, key):
    if root is None or root.data == key:
        return True
    if key < root.data:
        return search(root.left, key)
    return search(root.right, key)





n1 = Node(27)
n1.insert(14)
n1.insert(35)
n1.insert(10)
n1.insert(19)
n1.insert(31)
n1.insert(42)
print("Inorder Traversal")
inorder(n1)
print("\nPreorder Traversal")
preorder(n1)
print("\nPostorder Traversal")
postorder(n1)
print("\nLevel-order Traversal")
level(n1)
print("\nSize of the tree:", size(n1))
print("Minimum value in the tree:", min(n1))
print("Maximum value in the tree:", max(n1))

print("Found" if search(n1,14) else "Not Found")

