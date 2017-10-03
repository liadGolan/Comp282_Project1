package tree;

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
        /**CASE ONE: leaf deletion*/
        if(curr.left == null && curr.right == null) {
            if (parent.left ==curr) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        /**CASE TWO: One child*/
        else if (curr.left == null &&curr.right != null) { //if it is a right child
            parent.right = curr.right;
        }

        else if (curr.right == null && curr.left !=null) {
            parent.left = curr.left;
        }

        /**CASE THREE: Two children */
        else if (curr.left != null && curr.right != null){
            TreeNode favoriteChild = new TreeNode(root.element);
            //diamond right -> all the way left
            curr = curr.right;
            while (curr.left !=null){ //find replacement node
                favoriteChild = curr.left; //favorite child =  node found after one found after  doing left->right
            }
            //make favoriteChild's children the same as parent
            favoriteChild.right = parent.right;
            favoriteChild.left = parent.left;
            while (curr.left != null) { //move travel to favorite child's previous position
                curr = curr.left;
            }
            parent.left =null; //node was deleted

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
    /**Returns the number of non-leafnodes; Author: Edgar Cano*/
    public int getNumberofNonLeaves() {


        if (root.left == null && root.right == null) {
            return 0;
        } else {
            if(root.left !=null && root.right !=null)
            {
            Tree left = new Tree(root.left);
            Tree right = new Tree(root.right);

           return 1+left.getNumberofNonLeaves()+right.getNumberofNonLeaves();
            }else if(root.left != null && root.right == null)
            {
                Tree left = new Tree(root.left);
                return 1+left.getNumberofNonLeaves();

            }
            else if(root.left == null && root.right !=null){
                Tree right = new Tree(root.right);
                return 1 +right.getNumberofNonLeaves();
            }

    }
return 0;
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
}