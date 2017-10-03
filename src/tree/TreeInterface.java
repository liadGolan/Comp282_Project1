package tree;

public interface TreeInterface<E>
{
    /** Return true if the element is in the tree */
    public boolean search(E e);

    /** Insert element e into the binary search tree.
     * Return true if the element is inserted successfully */
    public boolean insert(E e);

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

    /**method for nonrecursive inorder method - Jemma*/
//    public void inorderNoRecursion();
}