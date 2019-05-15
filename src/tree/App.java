package tree;


public class App {
    public static void main(String[] args) {

        Tree myTree = new Tree();
        myTree.create();
        myTree.preorder(myTree.root);

    }
}
