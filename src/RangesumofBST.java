public class RangesumofBST
{
    static int sum=0;
    static class Node
    {
        int data;
        Node left;
        Node right;
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
            root.right =  insert(root.right, val);
        return root;
    }
    public static void preorderANDrangesum(Node root,int l, int r)
    {
        if(root == null)
            return;

        System.out.print(root.data+" ");
        if(root.data >= l && root.data <= r)
            sum=sum+root.data;
        preorderANDrangesum(root.left,l,r);
        preorderANDrangesum(root.right,l,r);
    }
    public static void main(String[] args)
    {
        int arr[] = {8,5,3,6,11,20};
        Node root = null;
        for(int i=0;i<arr.length; i++)
        {
            root = insert(root, arr[i]);
        }
        int l=9,r=15;
        preorderANDrangesum(root,l,r);
        System.out.println();
        System.out.println("The Range Sum is: "+sum);
    }
}
