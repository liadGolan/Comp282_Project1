package tree;

public class TreeRunner
{
    public static void main(String[] args)
    {
        Tree test = new Tree();

        System.out.println(test.isEmpty());

        test.insert("George");
        test.insert("Michael");
        test.insert("Tom");
        test.insert("Adam");
        test.insert("Jone");
        test.insert("Peter");

        test.inorder();
        System.out.println("");
        test.postorder();
        System.out.println("");
        test.preorder();
        System.out.println("");

        System.out.println(test.search("Adam"));
        System.out.println(test.search("Adams"));

        System.out.println("\n" + test.getSize());

//        test.delete("George");

        System.out.println("");

        System.out.println(test.isEmpty());

        test.inorder();

        //test for inorderNonrecursive
        System.out.println("_______________________________________");
        test.inorderNoRecursion();




    }
}
