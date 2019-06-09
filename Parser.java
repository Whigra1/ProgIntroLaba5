package oop5.ProgIntroLaba5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

//C:\Users\nazar\Downloads\Univwersitat\test.txt

public class Parser {
    private File file;
    private ArrayList<String> data;
    private LinkedList<String> queue;
    private LinkedList<String> postfixQueue;

    public Parser() throws Exception{
        data = new ArrayList<>();
        read();
        queue = new LinkedList<>();
        parsing();
        postfixQueue = new LinkedList<>();
        toPosrfix();
    }

    private void read()throws Exception{
        System.out.print("Enter WAY to File: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        file = new File(str);
        BufferedReader bR = new BufferedReader(new FileReader(file));
        String line = bR.readLine();
        while (line != null){
            data.add(line);
            line = bR.readLine();
        }
        bR.close();
        for (int i = 0; i < data.size(); i++){
            System.out.println(data.get(i));
        }
    }

    private void parsing() {
        String expression = data.get(data.size() - 1);
        String str = "";
        int index = 0;
        for (int i = 0; i < expression.length(); i++) {
            if(expression.substring(i, i + 1).equals("+") || expression.substring(i, i + 1).equals(";") || expression.substring(i, i + 1).equals("-")
            || expression.substring(i, i + 1).equals("/") || expression.substring(i, i + 1).equals("*") || expression.substring(i, i + 1).equals("(")
            || expression.substring(i, i + 1).equals(")") || expression.substring(i, i + 1).equals("^")) {
                str = expression.substring(index, i);
                if(i != 0 && index != i) queue.add(str);
                if(!expression.substring(i, i + 1).equals(";")) {
                    queue.add(expression.substring(i, i + 1));
                }
                index = i + 1;
            }
        }
        System.out.println("PARSER: ");
        int size = queue.size();
    }

    private void toPosrfix() {
        LinkedList<String> q1 = new LinkedList<>();
        go: while (!queue.isEmpty()) {
            String str = queue.removeFirst();
            System.out.println(str);
            if (str.equals("(")) {
                q1.add(str);
                continue;
            }
            if (str.equals(")")) {
                String str2 = q1.removeLast();
                while (!str2.equals("(")) {
                    postfixQueue.add(str2);
                    str2 = q1.removeLast();
                }
                continue;
            }
            if (cheack(str)) {
                if(str.equals("^") || str.equals("/") || str.equals("*")){
                    if(q1.peekLast().equals("-") || q1.peekLast().equals("+")){
                        q1.add(str);
                        continue;
                    }
                    else {
                        while (q1.peekLast().equals("(") || q1.peekLast().equals("-") || q1.peekLast().equals("+")){
                            String str2 = q1.removeLast();
                            postfixQueue.add(str2);
                        }
                        q1.add(str);
                        continue;
                    }
                }
                else{
                    if(q1.isEmpty()){
                        q1.add(str);
                        continue;
                    }
                    while ( !q1.isEmpty()){
                        if(q1.peekLast().equals("(")){
                            q1.add(str);
                            continue go;
                        }
                        postfixQueue.add(q1.removeLast());
                    }
                    q1.add(str);
                }
            }
            else{
                postfixQueue.add(str);
            }
        }
        int size = q1.size();
        for(int i = 0; i < size; i++){
            postfixQueue.add(q1.removeLast());
        }
        printPostfix();
    }

    private boolean cheack(String str){
        if(str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*") || str.equals("^")){
            return true;
        }
        else return false;
    }

    private void printPostfix(){
        System.out.println("POSTFIX:");
        int size = postfixQueue.size();
        for(int i = 0; i < size; i++){
            System.out.println("P: " + postfixQueue.removeFirst());
        }
    }

}
