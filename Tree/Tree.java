package Tree;

import java.util.LinkedList;
import java.util.Stack;

public class Tree {
    private Node root;
    final static String opers = "+-*/^";
    public void buildTree(String text){
        Stack<Node> stack = new Stack<>();
        for(int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '+' || text.charAt(i) == '*') {
                Node r = stack.pop();
                Node l = stack.pop();
                stack.push(new FunctionalNode(String.valueOf(text.charAt(i)),l,r));
            } else
                stack.push(new LeafNode(String.valueOf(text.charAt(i))));
        }
        root = stack.pop();
    }
    public void buildTree(LinkedList<String> text) {
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < text.size(); i++) {
            if (in(text.get(i))) {
                Node r = stack.pop();
                Node l = stack.pop();
                stack.push(new FunctionalNode(String.valueOf(text.get(i)), l, r));
            } else
                stack.push(new LeafNode(String.valueOf(text.get(i))));
        }
        root = stack.pop();
    }
    public int eval(){
           return root.eval();
    }
    public boolean in(String c){
        for (int i = 0; i < opers.length(); i++)
            if (c.equals(String.valueOf(opers.charAt(i))))
                return true;
        return false;
    }
    public static void main(String[] args) {
        String test = "25+678+**";
        Tree tree = new Tree();
        tree.buildTree(test);
        System.out.println(tree.eval());
        System.out.println();

    }
}
