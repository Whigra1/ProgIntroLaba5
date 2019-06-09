package Parsers;

public class AssignmentParser {
    public String findVar(String str){
        String [] parts = str.split("=");
        return parts[0];
    }
    public String findExpr(String str){
        String [] parts = str.split("=");
        return parts[1];
    }
}
