public class ValidateBST
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
    public static Boolean validateBST(Node root, Node min, Node max)
    {
        if(root == null)
            return true;

        if(min != null && root.data <= min.data)
            return false;
        
        else if(max != null && root.data >= max.data)
            return false;

        return validateBST(root.left, min, root) && validateBST(root.right, root, max);
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
    public static void main(String[] args)
    {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        if(validateBST(root , null, null))
            System.out.println("It is validate BST");
        else
            System.out.println("It is not validate BST");
    }
}
