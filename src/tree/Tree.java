package tree;

class Tree<E> implements TreeInterface<E>
{
    TreeNode root;
    public Tree()
    {

    }

    public Tree(TreeNode root)
    {
        this.root = root;
    }

    /** Return true if the element is in the tree */
    public boolean search(E e){
        Tree current = new Tree (root.left);
        if()
    }

    /** Insert element e into the binary search tree.
     * Return true if the element is inserted successfully */
    public boolean insert(E e)
    {
        if(root == null)
        {
            root = new TreeNode(e);
            return true;
        }
        else if(root.element.toString().compareTo(e.toString()) < 0)
        {
            if(root.left != null)
            {
                Tree current = new Tree(root.left);
                current.insert(e);
            }
            else
            {
                TreeNode left = new TreeNode(e);
                root.left = left;
                return true;
            }
        }
        else if(root.element.toString().compareTo(e.toString()) == 0)
        {
            return false;
        }
        else if(root.element.toString().compareTo(e.toString()) > 0)
        {
            if(root.right != null)
            {
                Tree current = new Tree(root.right);
                current.insert(e);
            }
            else
            {
                TreeNode right = new TreeNode(e);
                root.right = right;
                return true;
            }
        }
        else
        {
            return false;
        }

    }

    /** Delete the specified element from the tree.
     *  Return true if the element is deleted successfully */
    public boolean delete(E e);

    /** Inorder traversalfrom the root */
    public void inOrder(){
        if(root.left != null){
            Tree current = new Tree(root.left);
            current.inOrder();
        }
        System.out.println(root.element.toString());
        if(root.right != null){
            Tree current = new Tree(root.right);
            current.inOrder();
        }
    }

    /** postorder traversal from the root */
    public void postorder()
    {
        if(root.left != null)
        {
            Tree current = new Tree(root.left);
            current.postorder();
        }
        if(root.right != null)
        {
            Tree current = new Tree(root.right);
            current.postorder();
        }
        System.out.println(root.element);
    }

    /** preordertraversal from the root */
    public void preorder(){
        System.out.println(root.element.toString());
        if(root.left != null){
            Tree current = new Tree(root.left);
            current.preorder();
        }
        if(root.right != null){
            Tree current = new Tree(root.right);
            current.preorder();
        }
    }
    /** Get the number of nodes in the tree*/
    public int getSize();

    /**return true if the treeis empty*/
    public boolean isEmpty();
}