package oop5.ProgIntroLaba5.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Tree {
    private Node root;
    private final static String opers = "+-*/^";
    private HashMap<String,Integer> variables;
    public Tree(HashMap<String,Integer> vars){this.variables = vars;}
    public void buildTree(String text){
        Stack<Node> stack = new Stack<>();
        if (variables.size() > 0) {
            for (String s : variables.keySet())
                text = text.replaceAll(s, String.valueOf(variables.get(s)));
        }
        for(int i = 0; i < text.length(); i++) {
            if (in(String.valueOf(text.charAt(i)))){
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

    }
}
