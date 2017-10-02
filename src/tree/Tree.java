package tree;

import java.util.Stack;

class Tree <E extends Comparable  <E> > implements TreeInterface<E>
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
        if(e == root.element)
        {
            return true;
        }
        else if(e.compareTo((E) root.element)<0){
            if(root.left == null){
                return false;
            }
            else{
                Tree curr =  new Tree (root.left);
                return curr.search(e);
            }
        }
        else if(e.compareTo((E) root.element)>0) {
            if(root.right == null){
                return false;
            }
            else{
                Tree curr = new Tree (root.right);
                return curr.search(e);
            }
        }
        return false;
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
        else if(((E) root.element).compareTo(e) < 0)
        {
            if(root.right != null)
            {
                Tree current = new Tree(root.right);
                current.insert(e);
            }
            else
            {
                root.right = new TreeNode(e);
                return true;
            }
        }
        else if(((E)root.element).compareTo(e) == 0)
        {
            return false;
        }
        else if(((E) root.element).compareTo(e) > 0)
        {
            if(root.left != null)
            {
                Tree current = new Tree(root.left);
                current.insert(e);
            }
            else
            {
                root.left = new TreeNode(e);
                return true;
            }
        }

        return false;

    }

    /** Delete the specified element from the tree.
     *  Return true if the element is deleted successfully */
    public boolean delete(E e){

        TreeNode parent = new TreeNode(null);
        TreeNode curr =  new TreeNode(root.element);

        /** SEARCHING FOR ELEMENT  */
        while(curr != null){
            /**left side of tree*/
            if(e.compareTo((E) curr.element)<0){
                parent = curr;
                curr = curr.left;
            }
            /**right side of tree*/
            else if(e.compareTo((E)curr.element)>0){
                parent = curr;
                curr = curr.right;
            }
            else{ break; } //its in curr
        }
        /**CASE ONE: No left child*/
        if(curr.left == null){
            if(parent == null){ //curr is the root node
                root = curr.right;
            }
            else{
                if(e.compareTo((E)curr.element)<0){
                    parent.left = curr.right;
                }
                else{
                    parent.right = curr.right;
                }
            }
        }
        /**CASE TWO: current node has a left child*/
        else{

            TreeNode rightMostParent =  new TreeNode(curr);
            TreeNode rightMost = new TreeNode(curr.left);

            while(rightMost.right !=null){
                rightMostParent = rightMost.right;
            }

            curr.element = rightMost.element; //replaces curr element with rightmost element

            /**get rid of rightmost node */
            if(rightMostParent.right== rightMost){
                rightMostParent.right = rightMost.left;
            }
            else{
                rightMostParent.left = rightMost.left;
            }


        }
        return true; //element was deleted
    }


    /** Inorder traversalfrom the root */
    public void inorder(){
        if(root.left != null){
            Tree current = new Tree(root.left);
            current.inorder();
        }
        System.out.println(((E) root.element));
        if(root.right != null){
            Tree current = new Tree(root.right);
            current.inorder();
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
        System.out.println(((E) root.element));
    }

    /** preordertraversal from the root */
    public void preorder(){
        System.out.println(((E) root.element));
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
    public int getSize()
    {
        int size = 1;

        if(root.left != null)
        {
            Tree current = new Tree(root.left);
            size += current.getSize();
        }

        if(root.right != null)
        {
            Tree current = new Tree(root.right);
            size += current.getSize();
        }

        return size;
    }

    /**return true if the treeis empty*/
    public boolean isEmpty()
    {
        if(root == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void postOrderNoRecursion()
    {
        Stack postStack = new Stack();
        Stack pushed = new Stack();
        do {
            while (root != null)
            {
                if (root.right != null && pushed.search(root.right) < 1) {
                    postStack.push(root.right);
                }
                postStack.push(root);
                root = root.left;
            }

            root = (TreeNode) postStack.pop();

            if(root.right != null && pushed.search(root.right) < 1)
            {
                if (root.right.equals(postStack.peek()))
                {
                    postStack.pop();
                    postStack.push(root);
                    root = root.right;
                }
            }
            else
            {
                    System.out.println(root.element);
                    pushed.push(root);
                    root = null;
            }

        } while(!postStack.empty());

    }
}