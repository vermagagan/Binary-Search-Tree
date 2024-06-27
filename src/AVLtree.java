public class AVLtree
{
    static class Node
    {
        int data,height;
        Node left,right;
        public Node(int data)
        {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }
    public static int height(Node root)
    {
        if(root == null)
            return 0;
        return root.height;
    }
    public static int getBalance(Node root)
    {
        if(root == null)
            return 0;
        return(height(root.left)-height(root.right));
    }
    public static Node insert(Node root, int key)
    {
        if(root == null)
            return new Node(key);

        if(key < root.data)
            root.left = insert(root.left, key);
        else if(key > root.data)
            root.right = insert(root.right, key);
        else
            return root;

        root.height = 1+Math.max(height(root.left), height(root.right));
        int bf = getBalance(root);
        if(bf > 1 && key < root.left.data)
            return rightRotate(root);
        
        if(bf < -1 && key > root.right.data)
            return leftRotate(root);

        if(bf > 1 && key>root.left.data)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(bf < -1 && key < root.right.data)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
    
    public static Node leftRotate(Node X)
    {
        Node y=X.right;
        Node T2=y.left;
        y.left = X;
        X.right = T2;

        X.height = Math.max(height(X.left), height(X.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;

        return y;
    }
    public static Node rightRotate(Node Y)
    {
        Node x = Y.left;
        Node T2 = x.right;

        x.right = Y;
        Y.left = T2;

        Y.height = Math.max(height(Y.left), height(Y.right));
        x.height = Math.max(height(x.left), height(x.right));

        return x;
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
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 60);
        root = insert(root, 25);

        preorder(root);
    }
}
