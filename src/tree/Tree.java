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
    public boolean search(E e);

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
    public void inorder();

    /** postorder traversal from the root */
    public void postorder();

    /** preordertraversal from the root */
    public void preorder();

    /** Get the number of nodes in the tree*/
    public int getSize();

    /**return true if the treeis empty*/
    public boolean isEmpty();
}