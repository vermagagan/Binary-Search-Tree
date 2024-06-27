import java.util.ArrayList;

public class BsttoBalancedBSt
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
    public static void getInorder(Node root, ArrayList<Integer> al)
    {
        if(root == null)
            return;
        
        getInorder(root.left, al);
        al.add(root.data);
        getInorder(root.right, al);
    }
    public static void preorder(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static Node tobalancedBst(Node root)
    {
        ArrayList<Integer> al=new ArrayList<>();
        getInorder(root, al);
        return arrayToBst(al, 0, al.size()-1);
    }
    public static Node arrayToBst(ArrayList<Integer> al, int start, int end)
    {
        int mid;
        mid = (int) (start+end)/2;
        Node root=new Node(al.get(mid));
        if(start > end)
            return null;
        root.left = arrayToBst(al, start, mid-1);
        root.right = arrayToBst(al, mid+1, end);
        return root;
    }
    public static void main(String[] args)
    {
        
        Node root = new Node(10);
        root.left = new Node(9);
        root.left.left = new Node(8);
        root.left.left.left = new Node(7);
        root.right = new Node(11);
        root.right.right = new Node(12);
        root.right.right.right = new Node(13);
        preorder(root);
        System.out.println();
        root = tobalancedBst(root);
        preorder(root);
        
    }
}