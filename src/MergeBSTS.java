import java.util.ArrayList;
import java.util.Collections;

public class MergeBSTS
{
    static class Node
    {
        int data;
        Node left,right;
        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node mergeBst(Node root1, Node root2)
    {
        ArrayList<Integer> inorder1 = new ArrayList<>();
        getInorder(root1, inorder1);
        ArrayList<Integer> inorder2 = new ArrayList<>();
        getInorder(root2, inorder2);
        ArrayList<Integer> finalInorder = new ArrayList<>();
        Collections.sort(inorder1);
        Collections.sort(inorder2);
        for(int i=0; i<inorder1.size() && i<inorder2.size(); i++)
        {
            finalInorder.add(inorder1.get(i));
            finalInorder.add(inorder2.get(i));
        }
        Collections.sort(finalInorder);
        return arrayTobst(finalInorder, 0, finalInorder.size()-1);
    }
    public static Node arrayTobst(ArrayList<Integer> finalInorder, int start, int end)
    {
        int mid;
        mid = (int) (start+end)/2;
        Node root = new Node(finalInorder.get(mid));
        if(start > end)
            return null;

        root.left=arrayTobst(finalInorder, start, mid-1);
        root.right=arrayTobst(finalInorder, mid+1, end);
        return root;
    }
    public static void getInorder(Node root, ArrayList<Integer> inorder)
    {
        if(root ==  null)
            return;

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }
    public static void preorder(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args)
    {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        preorder(root1);
        System.out.println();
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        preorder(root2);
        System.out.println();
        Node mainroot = mergeBst(root1, root2);
        preorder(mainroot);

    }
}
