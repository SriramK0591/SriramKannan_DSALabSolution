import java.util.HashSet;

public class Pairsearch {

    // Creating the Node class for initiating the Tree variables
    static class Node  {
        int data;
        Node left, right;
    }

    // Method to have a new node if the tree is empty or does not have a root
    static Node Newnode(int data)
    {
        Node temp = new Node();
        temp.data=data;
        temp.left=null;
        temp.right=null;
        return temp;
    }

    // Method to insert a new node into the Binary Tree
    static Node insertNode(Node root, int key)
    {
        if (root==null)
        {
            return Newnode(key);
        }
        if (key<root.data)
        {
            root.left= insertNode(root.left, key);
        }
        if (key>root.data)
        {
            root.right= insertNode(root.right, key);
        }
        return root;
    }

    // Perform the search for a given sum/target in a binary tree
    private static boolean ispairintree(Node root, int tgt, HashSet<Integer> set)
    {
        if (root==null)
        {
            return false;
        }
        if (ispairintree(root.left,tgt, set))
        {  return true;
        }
        if (set.contains(tgt-root.data))
        {
            System.out.println("Pair is found: (" + (tgt-root.data) + "," + root.data + ")" + " for " + tgt);
            return true;
        }
        else
        {
            set.add(root.data);
        }
        return ispairintree(root.right,tgt, set);
    }

    // Retrieve the search output for a given sum/target in a binary tree
    static void ispairfound(Node root, int tgt)
    {
            HashSet<Integer> set = new HashSet<Integer>();
            if(!ispairintree(root, tgt, set))
            {
                System.out.println("Pair not found for the given Target: " + tgt);
            }
    }

    public static void main (String[] args) {
        Node root = null;
        root = insertNode(root, 30);
        root = insertNode(root, 40);
        root = insertNode(root, 50);
        root = insertNode(root, 60);
        root = insertNode(root, 70);
        root = insertNode(root, 80);
        // Check if the given target is present or not in a binary tree
        ispairfound(root,150);
    }
}
