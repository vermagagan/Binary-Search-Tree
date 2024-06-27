public class SearchinBST
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
    public static Boolean searchBST(Node root, int key)
    {
        if(root == null)
            return false;
        if(root.data == key)
            return true;
        else if(root.data>key)
            return searchBST(root.left, key);
        else
            return searchBST(root.right, key);
    }
    public static void main(String[] args)
    {
        int key = 15;
        int val[] = {8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0; i<val.length; i++)
        {
            root = insert(root,val[i]);
        }
        if(searchBST(root, key))
            System.out.println("The number is found and present in tree");
        else
            System.out.println("The number is not present in tree and not found");
    }
}
