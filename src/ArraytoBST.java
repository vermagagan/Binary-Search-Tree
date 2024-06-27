public class ArraytoBST
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
    public static Node arrTobst(int arr[], int s, int e)
    {
        int mid;
        mid = (int) (s+e)/2;
        Node root = new Node(arr[mid]);
        if(s > e)
            return null;
        root.left = arrTobst(arr, s, mid-1);
        root.right = arrTobst(arr, mid+1, e);
        return root;

    }
    public static void preorder(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root)
    {
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    
    public static void main(String[] args)
    {
        int arr[] = {3,6,5,8,10,11,12};
        Node croot = arrTobst(arr, 0, arr.length-1);
        preorder(croot);
        System.out.println();
        inorder(croot);
    }
}
