import java.util.*;

class BST {
  // do not change this
  private Node root;
  private ArrayList<Integer> data;

  // DO NOT MODIFY THIS METHOD
  public BST() {
    root = null;
    data = new ArrayList<Integer>(0);
  }

  // DO NOT MODIFY THIS METHOD
  public ArrayList<Integer> getData() {
    return data;
  }

  // DO NOT MODIFY THIS METHOD
  public void inOrderTraversal() {
      inOrderTraversal(root);
  }

  // DO NOT MODIFY THIS METHOD
  private void inOrderTraversal(Node node) {
      if (node != null) {
          inOrderTraversal(node.left);
          data.add(node.key);
          inOrderTraversal(node.right);
      }
  }



  // search
  public boolean search(int target) {
    return search(root, target);
  }



  // insert
  public Node insert(int target) {
    root = insert(root, target);
    return root;
  }



  // note: you may need to implement several supporting methods for delete
  public Node delete(int target) {
    delete(get(target));
    return root;
  }



  // you are welcome to add any supporting methods
  public boolean search(Node node, int target) {
    if (node == null) {
      return false;
    } else if (node != null && node.key == target) {
      return true;
    }
    if (target < node.key) {
      return search(node, target);
    } else {
      return search(node, target);
    }
  }


// Inserts a value into a BST given a node
  public Node insert(Node node, int val) {
    if (node == null) {
      return new Node(val);
    }
    if (val < node.key) {
      node.left = insert(node.left, val);
    } else {
      node.right = insert(node.right, val);
    }
    return node;
  }



  public void replace_node_in_parent(Node node, Node newNode) {
    if (node.parent == null) {
      node.parent = newNode;
      return;
    }
    if (node.parent.left == node) {
      node.parent.left = newNode;
    } else {
      node.parent.right = newNode;
    }
  }



  public int find_next_smallest(Node node) {
    Node current_node = node.right;
    while (current_node.left != null) {
      current_node = current_node.left;
    }
    return current_node.key;
  }



  public Node get(int val) {
    return get(root, val);
  }




  public Node get(Node node, int val) {
    if (node == null) {
      return null;
    }
    if (val < node.key) {
      return get(node.left, val);
    } else if (val > node.key) {
      return get(node.right, val);
    } else {
      return node;
    }
  }



  public void delete(Node node) {
    if (node == null) {
      System.out.print("Failed to remove. DNE in this BST");
      return;
    }
    if (node.right == null && node.left == null) {
      replace_node_in_parent(node, null);
    } else if (node.right == null && node.left != null) {
      replace_node_in_parent(node, node.left);
    } else if (node.right != null && node.left == null) {
      replace_node_in_parent(node, node.right);
    } else {
      int val2 = find_next_smallest(node);
      Node node_smallest = get(val2);
      delete(node_smallest);
      node.key = val2;
    }
  }




  public Node returnRoot() {
    return root;
  }




  public void clearArrayList() {
    data.clear();
  }





}
