from collections import deque


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def insert(self, data):
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


class BinarySearchTree:
    def __init__(self, root=None):
        self.root = root

    def insert(self, data):
        if self.root is None:
            self.root = Node(data)
        else:
            self.root.insert(data)

    def inorder(self):
        self._inorder(self.root)

    def _inorder(self, node):
        if node:
            self._inorder(node.left)
            print(node.data, end=" ")
            self._inorder(node.right)

    def preorder(self):
        self._preorder(self.root)

    def _preorder(self, node):
        if node:
            print(node.data, end=" ")
            self._preorder(node.left)
            self._preorder(node.right)

    def postorder(self):
        self._postorder(self.root)

    def _postorder(self, node):
        if node:
            self._postorder(node.left)
            self._postorder(node.right)
            print(node.data, end=" ")

    def level(self):
        if not self.root:
            return None
        q = deque([self.root])
        while q:
            current = q.popleft()
            print(current.data, end=" ")
            if current.left:
                q.append(current.left)
            if current.right:
                q.append(current.right)

    def size(self):
        return self._size(self.root)

    def _size(self, node):
        if node is None:
            return 0
        return self._size(node.left) + 1 + self._size(node.right)

    def min(self):
        return self._min(self.root)

    def _min(self, node):
        while node.left:
            node = node.left
        return node.data

    def max(self):
        return self._max(self.root)

    def _max(self, node):
        while node.right:
            node = node.right
        return node.data

    def search(self, key):
        return self._search(self.root, key)

    def _search(self, node, key):
        if node is None or node.data == key:
            return node is not None
        if key < node.data:
            return self._search(node.left, key)
        return self._search(node.right, key)


if __name__ == "__main__":
    bst = BinarySearchTree()
    for value in [27, 14, 35, 10, 19, 31, 42]:
        bst.insert(value)

    print("Inorder Traversal")
    bst.inorder()
    print("\nPreorder Traversal")
    bst.preorder()
    print("\nPostorder Traversal")
    bst.postorder()
    print("\nLevel-order Traversal")
    bst.level()
    print("\nSize of the tree:", bst.size())
    print("Minimum value in the tree:", bst.min())
    print("Maximum value in the tree:", bst.max())
    print("Found" if bst.search(14) else "Not Found")
