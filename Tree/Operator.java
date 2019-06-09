package Tree;

public class Operator{
    private int operands;
    private String operator;
    public Operator(String operator){
        this.operands = operands;
        this.operator = operator;
    }
    public int eval(int a, int b){
        if (operator.equals("+"))
            return a + b;
        if (operator.equals("*"))
            return a * b;
        if (operator.equals("/"))
            return a / b;
        if (operator.equals("-"))
            return a - b;
        if (operator.equals("^"))
            return (int) Math.pow(a,b);
        return 0;
    }
}

