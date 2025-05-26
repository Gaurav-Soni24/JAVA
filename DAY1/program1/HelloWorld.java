package program1;

public class HelloWorld {
    HelloWorld() {
        System.out.println("Hello, World!");
    }

    HelloWorld(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        HelloWorld helloworld = new HelloWorld();
        HelloWorld helloworld2 = new HelloWorld("Gaurav");
    }
}