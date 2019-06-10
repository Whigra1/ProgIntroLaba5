package oop5.ProgIntroLaba5;
import java.util.HashMap;

import oop5.ProgIntroLaba5.Parsers.AssignmentParser;
import oop5.ProgIntroLaba5.Tree.Tree;

public class Main {
    public static void main(String[] args) throws Exception{
        miniTest();
    }

    public static void miniTest(){
        HashMap<String,Integer> variables = new HashMap<>();
        AssignmentParser p = new AssignmentParser();
        Tree tree = new Tree(variables);
        String lines = "a=5\nc=25+\nb=23+1-\nab*";
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
