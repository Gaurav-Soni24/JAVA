package program3;

public class FlowControl {
    public void ifStatement(){
        int a = 10;
        if(a > 0){
            System.out.println("a is greater than 0");
        }
    }

    public void ifElseStatement(){
        int a = -5; // Changed to demonstrate else condition
        if(a > 0){
            System.out.println("a is greater than 0");
        } else {
            System.out.println("a is not greater than 0");
        }
    }

    public void ifElseIfStatement(){
        int a = 0; // Changed to demonstrate else if condition
        if(a > 0){
            System.out.println("a is greater than 0");
        } else if(a == 0){
            System.out.println("a is equal to 0");
        } else {
            System.out.println("a is less than 0");
        }
    }

    public void switchStatement(String i){
        int a = 10;
        switch(a){
            case 10:
                System.out.println("a is 10");
                break;
            default:
                System.out.println("a is not 10");
        }
        System.out.println("i is " + i);
    }

    public void whileLoop(){
        int i = 0;
        while(i < 10){
            System.out.println("i is " + i);
            i++;
        }
    }

    public void doWhileLoop(){
        int i = 0;
        do{
            System.out.println("i is " + i);
            i++;
        }while(i < 10);
    }

    public void nestedLoop(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.println("i is " + i + " and j is " + j);
            }
        }
    }

    public void breakStatement(){
        for(int i = 0; i < 10; i++){
            if(i == 5){
                break;
            }
            System.out.println("i is " + i);
        }
    }

    public void continueStatement(){
        for(int i = 0; i < 10; i++){
            if(i == 5){
                continue;
            }
            System.out.println("i is " + i);
        }
    }

    public int returnStatement(){
        return 0;
    }

    public void throwStatement() throws Exception{
        throw new Exception("This is a custom exception");
    }

    public void tryCatchStatement(){
        try{
            throw new Exception("This is a custom exception");
        }catch(Exception e){
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public void finallyStatement(){
        try{
            throw new Exception("This is a custom exception");
        }catch(Exception e){
            System.out.println("Caught exception: " + e.getMessage());
        }finally{
            System.out.println("This is a finally block");
        }
    }

    public static void main(String[] args) {
        FlowControl flowControl = new FlowControl();
        flowControl.ifStatement();
        flowControl.ifElseStatement();
        flowControl.ifElseIfStatement();
        flowControl.switchStatement("test string");
        flowControl.whileLoop();
        flowControl.doWhileLoop();
        flowControl.nestedLoop();
        flowControl.breakStatement();
        flowControl.continueStatement();
        System.out.println("Return value: " + flowControl.returnStatement());
        flowControl.tryCatchStatement();
        flowControl.finallyStatement();
        
        // Note: throwStatement() is not called in main because it throws an exception
        // If you want to test it, wrap it in a try-catch block
    }
}