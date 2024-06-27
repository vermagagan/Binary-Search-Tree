import java.util.ArrayList;

public class Kthsmallestandlargest
{
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
    public static int kthLargest(Node root, int k)
    {
        if(root == null)
            return -1;

        ArrayList<Integer> al=new ArrayList<>();
        getInorder(root,al);
        return al.get(al.size()-k);
    }
    public static int kthSmallest(Node root, int k)
    {
        if(root == null)
            return -1;

        ArrayList<Integer> al=new ArrayList<>();
        getInorder(root,al);
        return al.get(k-1);
    }
    public static void getInorder(Node root, ArrayList<Integer> al)
    {
        if(root == null)
            return;
        getInorder(root.left, al);
        al.add(root.data);
        getInorder(root.right, al);
    }

    public static void main(String[] args)
    {
        int arr[] = {8,5,3,6,11,20};
        Node root = null;
        for(int i=0;i<arr.length; i++)
        {
            root = insert(root, arr[i]);
        }
        int k = 3;
        System.out.println("The "+k+"th Largest number is : "+kthLargest(root, k));
        System.out.println("The "+k+"th Smallest number is : "+kthSmallest(root,k));
    }
}
