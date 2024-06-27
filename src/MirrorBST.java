public class MirrorBST
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
    public static void inorder(Node root)
    {
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static Node mirrorBst(Node root)
    {
        if(root == null)
            return null;

        Node left = mirrorBst(root.left);
        Node right = mirrorBst(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
    public static void main(String[] args)
    {
        int val[] = {5,1,4,3,2,7};
        Node root = null;
        for(int i=0; i<val.length; i++)
        {
            root = insert(root,val[i]);
        }
        inorder(root);
        System.out.println();
        root = mirrorBst(root);
        inorder(root);
        System.out.println();
    }
}
