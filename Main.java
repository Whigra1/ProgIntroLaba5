import java.util.LinkedList;
import Tree.Tree;
public class Main {
    public static void main(String[] args) throws Exception{
        Parser p = new Parser();
        LinkedList<String> chars = p.toPosrfix();
        Tree tree = new Tree();
        tree.buildTree(chars);
        System.out.println(chars);
        System.out.println(tree.eval());
    }
}
