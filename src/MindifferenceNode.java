public class MindifferenceNode
{

    
    static int min = Integer.MAX_VALUE ,mindiffkey;
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


    public static void minifferenceNodeutil(Node root, int key)
    {
        if(root == null)
            return ;
        if(Math.abs(root.data-key) < min)
        {
            min = Math.abs(root.data-key);
            mindiffkey = root.data;
        }
        minifferenceNodeutil(root.left, key);
        minifferenceNodeutil(root.right, key);
    }


    public static void main(String[] args)
    {
        int arr[] = {8,5,3,6,11,20};
        Node root = null;
        for(int i=0;i<arr.length; i++)
        {
            root = insert(root, arr[i]);
        }
        int key = 9;
        minifferenceNodeutil(root,key);
        System.out.println(mindiffkey+"(difference is "+min+")");
    }
}
