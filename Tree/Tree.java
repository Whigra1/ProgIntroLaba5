package Tree;

import java.util.Stack;

public class Tree {
    private Node root;
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
    public int eval(){
        return root.eval();
    }
    public static void main(String[] args) {
        String test = "25+678+**";
        Tree tree = new Tree();
        tree.buildTree(test);
        System.out.println(tree.eval());
        System.out.println();

    }
}