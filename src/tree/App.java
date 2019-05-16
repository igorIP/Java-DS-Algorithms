package tree;


public class App {
    public static void main(String[] args) {

        Tree myTree = new Tree();
        myTree.create();
        //myTree.preorder(myTree.root);
        //myTree.postorder();
        //myTree.inorder(myTree.root);
        //myTree.levelorder(myTree.root);
        //System.out.println(myTree.height(myTree.root));

        //Iterative
        myTree.preorderIterative();
    }
}
