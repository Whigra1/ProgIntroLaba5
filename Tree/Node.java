package Tree;

abstract class Node {
    Node left;
    Node right;
    abstract int eval();
}


class FunctionalNode extends Node{
    private String oper;
    private Operator operator;
    public FunctionalNode(String oper){
        this.oper = oper;
        operator = new Operator(oper);
    }
    public FunctionalNode(String oper, Node l, Node r){
        this.oper = oper;
        operator = new Operator(oper);
        this.left = l;
        this.right = r;
    }
    public int eval(){
        return operator.eval(left.eval(),right.eval());
    }
}


class LeafNode extends Node{
    private int val;
    public LeafNode(int val){
        this.val = val;
    }
    public LeafNode(String val){
        this.val = Integer.valueOf(val);
    }
    public int eval(){
        return val;
    }
}


