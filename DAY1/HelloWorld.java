// HelloWorld in java

public class HelloWorld {
    HelloWorld() {
        System.out.println("Hello, World!");
    }

    HelloWorld(String name) {   
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        HelloWorld helloWorld2 = new HelloWorld("Gaurav");
    }
}




