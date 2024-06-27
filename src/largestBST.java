public class largestBST
{
    static int maxBST=0;
    static Node curr=null;
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
    static class Info
    {
        boolean isbst;
        int size;
        int min;
        int max;
        public Info(boolean isbst, int size, int min, int max)
        {
            this.isbst = isbst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static Info largestBst(Node root)
    {
        if(root == null)
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Info leftinfo = largestBst(root.left);
        Info rightInfo = largestBst(root.right);
        int size = leftinfo.size+rightInfo.size+1;
        int min = Math.min(root.data,Math.min(leftinfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftinfo.max, rightInfo.max));

        if(root.data <= leftinfo.max || root.data >= rightInfo.min)
            return new Info(false, size, min, max);
        if(leftinfo.isbst && rightInfo.isbst)
        {
            maxBST = Math.max(maxBST, size);
            curr = root;
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
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
        Node root=new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        Info iff= largestBst(root);
        System.out.println("The largest BST has "+maxBST+" nodes and the preorder of tree is");
        preorder(curr);
    }
}
