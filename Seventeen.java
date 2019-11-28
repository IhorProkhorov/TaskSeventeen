import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;

public class Seventeen {

    private static String path = "E:\\test.xml";
    private String[] stack;
    private int top;

    public Seventeen(int capacity) {
        stack = new String[capacity];
    }

    public static void main(String[]args){
        Seventeen seventeen = new Seventeen(6);
        System.out.println(seventeen.isValidXml(path));
        System.out.println(seventeen.top);
    }

    public boolean isValidXml(String path){
        boolean flag = false;
        try{
            FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                try{
                    if (strLine.substring(2).equals(peek().substring(1))){
                    pop();
                    }else push(strLine);
                }catch (EmptyStackException ex){
                    push(strLine);
                }
            }
        }catch (IOException e){
            return false;
        }
        if (isEmpty()){
            flag = true;
        }
        return flag;
    }

    public String peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public void push(String str){
        if ( top == stack.length){
            String[] array = new String[2 * stack.length];
            System.arraycopy(stack,0,array,0,stack.length);
            stack = array;
        }
        stack[top++] = str;
    }

    public String pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        String string = stack[--top];
        stack[top] = null;
        return string;
    }

    public boolean isEmpty(){
        return top == 0;
    }

}
