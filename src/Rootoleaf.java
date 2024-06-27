import java.util.ArrayList;
public class Rootoleaf
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
    public static void Path(Node root, ArrayList<Integer> path)
    {
        if(root == null)
            return;

        path.add(root.data);
        Path(root.left, path);
        if(root.left == null && root.right == null)
            System.out.println(path);
        Path(root.right, path);
        path.remove(path.size()-1);
    }
    public static void main(String[] args)
    {
        int val[] = {8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0; i<val.length; i++)
        {
            root = insert(root,val[i]);
        }
        inorder(root);
        System.out.println();
        Path(root, new ArrayList<>());
    }
}
