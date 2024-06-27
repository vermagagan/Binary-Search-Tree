public class Deletenode
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
    public static Node deleteNode(Node root, int key)
    {
        if(root.data > key)
            root.left = deleteNode(root.left, key);
        else if(root.data < key)
            root.right = deleteNode(root.right, key);
        else
        {
            //no child
            if(root.left == null && root.right == null)
                return null;
            //1 child
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            //both child
            Node inordersuccessor = findSuccessor(root.right);
            root.data = inordersuccessor.data;
            root.right = deleteNode(root.right,inordersuccessor.data);
        }
        return root;
    }
    public static Node findSuccessor(Node root)
    {
        while(root.left != null)
            root = root.left;
        return root;
    }
    public static void main(String[] args)
    {
        int key = 5;
        int val[] = {8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0; i<val.length; i++)
        {
            root = insert(root,val[i]);
        }
        inorder(root);
        System.out.println();
        deleteNode(root, key);
        inorder(root);
    }
}
