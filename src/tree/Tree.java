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
    public boolean insert(E e);

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
    public void postorder();

    /** preordertraversal from the root */
    public void preorder();

    /** Get the number of nodes in the tree*/
    public int getSize();

    /**return true if the treeis empty*/
    public boolean isEmpty();
}