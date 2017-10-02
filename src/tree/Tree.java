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

        return false;

    }

    /** Delete the specified element from the tree.
     *  Return true if the element is deleted successfully */
    public boolean delete(E e){

        TreeNode parent = new TreeNode(null);
        TreeNode curr =  new TreeNode(root);

        /** SEARCHING FOR ELEMENT  */
        while(curr != null){
            /**left side of tree*/
            if(e.toString().compareTo(curr.element.toString())<0){
                parent = curr;
                curr = curr.left;
            }
            /**right side of tree*/
            else if(e.toString().compareTo(curr.element.toString())>0){
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
                if(e.toString().compareTo(curr.element.toString())<0){
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
        if(root.element == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}