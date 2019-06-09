import java.util.HashMap;
import java.util.LinkedList;

import Parsers.AssignmentParser;
import Tree.Tree;
public class Main {
    public static void main(String[] args) throws Exception{
        miniTest();
    }
    public static void test(Tree tree, AssignmentParser parser, HashMap<String,Integer> variables){
        String text1 = "c=23+";
        String text2 = "a=53+";
        String text3 = "b=13+";
        String expr = parser.findExpr(text1);
        String var = parser.findVar(text1);
        tree.buildTree(expr);
        variables.put(var,tree.eval());
        expr = parser.findExpr(text2);
        var = parser.findVar(text2);
        tree.buildTree(expr);
        variables.put(var,tree.eval());
        expr = parser.findExpr(text3);
        var = parser.findVar(text3);
        tree.buildTree(expr);
        variables.put(var,tree.eval());
    }
    public static void miniTest(){
        HashMap<String,Integer> variables = new HashMap<>();
        AssignmentParser p = new AssignmentParser();
        Tree tree = new Tree(variables);
        String lines = "a=5\nc=25+\nac*";
        for (String s:lines.split("\n"))
            if(s.contains("=")){
                String var = p.findVar(s);
                String expr = p.findExpr(s);
                tree.buildTree(expr);
                variables.put(var, tree.eval());
            }
            else{
                tree.buildTree(s);
                System.out.println(tree.eval());
            }


    }

}
