package jugacademi.binarysearchtree;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {
    private Node root;
    private java.util.List<Integer> traverse;

//    public static void main(String[] args) {
//        BinarySearchTree tree = new BinarySearchTree();
//        tree.insert(1);
//        tree.insert(5);
//        tree.insert(2);
//        tree.insert(4);
//        tree.insert(1);
//        System.out.println(tree.traverse());
//
//    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean insert(int value){
        Node currentRoot = root;
        if(root == null){
            root = new Node();
            root.setValue(value);
            return true;
        }
        while(currentRoot != null){
            if(currentRoot.getValue() > value){
                if(currentRoot.getLeft()==null){
                    currentRoot.setLeft(new Node());
                    currentRoot.getLeft().setValue(value);
                    return true;
                }
                currentRoot = currentRoot.getLeft();

            }else if(currentRoot.getValue() < value){
                if(currentRoot.getRight() == null){
                    currentRoot.setRight(new Node());
                    currentRoot.getRight().setValue(value);
                    return true;
                }
                currentRoot = currentRoot.getRight();
            }else{
                return false;
            }
        }
        return false;
    }
    public boolean search(int value){
        Node currentRoot = root;
        if(currentRoot == null){
            return false;
        }
        while(currentRoot != null){
            if(currentRoot.getValue() > value){
                currentRoot = currentRoot.getLeft();
            }else if(currentRoot.getValue()<value){
                currentRoot = currentRoot.getRight();
            }else{
                return true;
            }
        }
        return false;

    }

    public java.util.List<Integer> traverse(){
        traverse = new java.util.LinkedList<>();
        Node currentRoot = root;
        if(currentRoot==null){
            return traverse;
        }
        inOrderWalkTree(root);
        return traverse;
    }

    public void inOrderWalkTree(Node node){
        if(node == null){
            return;
        }
        inOrderWalkTree(node.getLeft());
        traverse.add(node.getValue());
        inOrderWalkTree(node.getRight());
    }

}
