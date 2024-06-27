public class Printinrange
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
    public static void inorder(Node root)
    {
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static Node insert(Node root, int val)
    {
        if(root == null)
        {
            root = new Node(val);
            return root;
        }
        if(root.data > val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
    }
    public static void printInrange(Node root, int k1, int k2)
    {
        if(root == null)
            return;
        if(root.data >= k1 && root.data <= k2)
        {
            printInrange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInrange(root.right, k1, k2);
        }
        if(root.data < k1)
            printInrange(root.left, k1, k2);
        if(root.data > k2)
            printInrange(root.right, k1, k2);
    }
    public static void main(String[] args)
    {
        int val[] = {8,5,3,1,4,6,10,11,14};
        int k1=5, k2=10;
        Node root = null;
        for(int i=0; i<val.length; i++)
        {
            root = insert(root,val[i]);
        }
        inorder(root);
        System.out.println();
        printInrange(root,k1,k2);
    }
}
