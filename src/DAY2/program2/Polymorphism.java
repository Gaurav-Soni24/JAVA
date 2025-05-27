/**
 * Comprehensive Java Program demonstrating Compile-Time and Runtime Polymorphism
 *
 * POLYMORPHISM OVERVIEW:
 * Polymorphism means "many forms" - the ability of objects to take multiple forms.
 * Java supports two types of polymorphism:
 * 1. Compile-Time Polymorphism (Static Polymorphism)
 * 2. Runtime Polymorphism (Dynamic Polymorphism)
 */

// =============================================================================
// PART 1: COMPILE-TIME POLYMORPHISM (STATIC POLYMORPHISM)
// =============================================================================

/**
 * Compile-Time Polymorphism is achieved through:
 * 1. Method Overloading
 * 2. Constructor Overloading
 * 3. Operator Overloading (limited in Java)
 *
 * The method to be called is determined at compile time based on:
 * - Method name
 * - Number of parameters
 * - Type of parameters
 * - Order of parameters
 */

class Calculator {
    // Method Overloading Examples - Same method name, different parameters

    // Method 1: Two integers
    public int add(int a, int b) {
        System.out.println("Adding two integers: " + a + " + " + b);
        return a + b;
    }

    // Method 2: Three integers
    public int add(int a, int b, int c) {
        System.out.println("Adding three integers: " + a + " + " + b + " + " + c);
        return a + b + c;
    }

    // Method 3: Two doubles
    public double add(double a, double b) {
        System.out.println("Adding two doubles: " + a + " + " + b);
        return a + b;
    }

    // Method 4: String concatenation
    public String add(String a, String b) {
        System.out.println("Concatenating strings: '" + a + "' + '" + b + "'");
        return a + b;
    }

    // Method 5: Different parameter order
    public String add(String str, int num) {
        System.out.println("String + Integer: '" + str + "' + " + num);
        return str + num;
    }

    public String add(int num, String str) {
        System.out.println("Integer + String: " + num + " + '" + str + "'");
        return num + str;
    }

    // Constructor Overloading
    private String calculatorType;
    private String version;

    // Default constructor
    public Calculator() {
        this.calculatorType = "Basic";
        this.version = "1.0";
        System.out.println("Created basic calculator v1.0");
    }

    // Constructor with type
    public Calculator(String type) {
        this.calculatorType = type;
        this.version = "1.0";
        System.out.println("Created " + type + " calculator v1.0");
    }

    // Constructor with type and version
    public Calculator(String type, String version) {
        this.calculatorType = type;
        this.version = version;
        System.out.println("Created " + type + " calculator v" + version);
    }

    public void displayInfo() {
        System.out.println("Calculator Type: " + calculatorType + ", Version: " + version);
    }
}

// =============================================================================
// PART 2: RUNTIME POLYMORPHISM (DYNAMIC POLYMORPHISM)
// =============================================================================

/**
 * Runtime Polymorphism is achieved through:
 * 1. Method Overriding
 * 2. Interface Implementation
 * 3. Abstract Class Implementation
 *
 * The actual method to be called is determined at runtime based on the
 * actual object type, not the reference type (Dynamic Method Dispatch)
 */

// Base class (Superclass)
abstract class Shape {
    protected String color;
    protected double x, y; // position

    public Shape(String color, double x, double y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    // Abstract method - must be overridden by subclasses
    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    // Concrete method that can be overridden
    public void display() {
        System.out.println("Shape: " + this.getClass().getSimpleName() +
                ", Color: " + color + ", Position: (" + x + ", " + y + ")");
    }

    // Method that uses polymorphism internally
    public void printDetails() {
        display();
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("------------------------");
    }
}

// Subclass 1: Circle
class Circle extends Shape {
    private double radius;

    public Circle(String color, double x, double y, double radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Radius: " + radius);
    }

    // Circle-specific method
    public double getDiameter() {
        return 2 * radius;
    }
}

// Subclass 2: Rectangle
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(String color, double x, double y, double width, double height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Width: " + width + ", Height: " + height);
    }

    // Rectangle-specific method
    public boolean isSquare() {
        return width == height;
    }
}

// Subclass 3: Triangle
class Triangle extends Shape {
    private double side1, side2, side3;

    public Triangle(String color, double x, double y, double side1, double side2, double side3) {
        super(color, x, y);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        // Using Heron's formula
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Sides: " + side1 + ", " + side2 + ", " + side3);
    }
}

// Interface for demonstrating polymorphism
interface Drawable {
    void draw();
    void erase();
}

interface Movable {
    void move(double deltaX, double deltaY);
    void rotate(double angle);
}

// Class implementing multiple interfaces
class GraphicsShape extends Circle implements Drawable, Movable {
    private boolean isVisible;

    public GraphicsShape(String color, double x, double y, double radius) {
        super(color, x, y, radius);
        this.isVisible = true;
    }

    @Override
    public void draw() {
        if (isVisible) {
            System.out.println("Drawing circle at (" + x + ", " + y + ") with radius " + getDiameter()/2);
        }
    }

    @Override
    public void erase() {
        System.out.println("Erasing circle at (" + x + ", " + y + ")");
        isVisible = false;
    }

    @Override
    public void move(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
        System.out.println("Moved circle to (" + x + ", " + y + ")");
    }

    @Override
    public void rotate(double angle) {
        System.out.println("Circle rotated by " + angle + " degrees (no visual change)");
    }
}

// =============================================================================
// MAIN CLASS - DEMONSTRATION
// =============================================================================

public class Polymorphism {

    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("JAVA POLYMORPHISM DEMONSTRATION");
        System.out.println("=".repeat(80));

        // =======================================================================
        // COMPILE-TIME POLYMORPHISM DEMONSTRATION
        // =======================================================================

        System.out.println("\n1. COMPILE-TIME POLYMORPHISM (STATIC POLYMORPHISM)");
        System.out.println("-".repeat(60));

        System.out.println("\nA. Method Overloading:");
        Calculator calc1 = new Calculator();
        Calculator calc2 = new Calculator("Scientific");
        Calculator calc3 = new Calculator("Graphing", "2.5");

        System.out.println("\nDifferent method calls resolved at compile time:");
        System.out.println("Result: " + calc1.add(5, 3));                    // int, int
        System.out.println("Result: " + calc1.add(1, 2, 3));                // int, int, int
        System.out.println("Result: " + calc1.add(2.5, 3.7));               // double, double
        System.out.println("Result: " + calc1.add("Hello", "World"));        // String, String
        System.out.println("Result: " + calc1.add("Value: ", 42));           // String, int
        System.out.println("Result: " + calc1.add(100, " items"));           // int, String

        System.out.println("\nB. Constructor Overloading:");
        calc1.displayInfo();
        calc2.displayInfo();
        calc3.displayInfo();

        // =======================================================================
        // RUNTIME POLYMORPHISM DEMONSTRATION
        // =======================================================================

        System.out.println("\n\n2. RUNTIME POLYMORPHISM (DYNAMIC POLYMORPHISM)");
        System.out.println("-".repeat(60));

        System.out.println("\nA. Method Overriding with Inheritance:");

        // Creating objects - same reference type, different object types
        Shape[] shapes = {
                new Circle("Red", 0, 0, 5),
                new Rectangle("Blue", 10, 10, 4, 6),
                new Triangle("Green", 5, 5, 3, 4, 5),
                new Circle("Yellow", -2, 3, 7.5)
        };

        System.out.println("Polymorphic behavior - same method call, different implementations:");
        for (Shape shape : shapes) {
            // The actual method called depends on the runtime object type
            shape.printDetails();
        }

        System.out.println("\nB. Interface Implementation:");

        // Interface references pointing to different implementations
        Drawable[] drawables = {
                new GraphicsShape("Purple", 0, 0, 3),
                new GraphicsShape("Orange", 5, 5, 2)
        };

        Movable[] movables = {
                new GraphicsShape("Cyan", 1, 1, 4),
                new GraphicsShape("Magenta", -1, -1, 1.5)
        };

        System.out.println("Interface polymorphism:");
        for (Drawable drawable : drawables) {
            drawable.draw();
        }

        for (Movable movable : movables) {
            movable.move(2, 3);
            movable.rotate(45);
        }

        // =======================================================================
        // ADVANCED RUNTIME POLYMORPHISM CONCEPTS
        // =======================================================================

        System.out.println("\nC. Dynamic Method Dispatch:");

        // Reference type vs Object type
        Shape circleRef = new Circle("Black", 0, 0, 10);
        Shape rectangleRef = new Rectangle("White", 0, 0, 8, 12);

        // Method resolution happens at runtime
        System.out.println("Circle area (via Shape reference): " + circleRef.calculateArea());
        System.out.println("Rectangle area (via Shape reference): " + rectangleRef.calculateArea());

        // Demonstrating late binding
        demonstratePolymorphism(circleRef);
        demonstratePolymorphism(rectangleRef);

        // =======================================================================
        // KEY DIFFERENCES SUMMARY
        // =======================================================================

        System.out.println("\n\n3. KEY DIFFERENCES SUMMARY");
        System.out.println("-".repeat(60));

        System.out.println("\nCOMPILE-TIME POLYMORPHISM:");
        System.out.println("• Also called Static Polymorphism");
        System.out.println("• Achieved through method/constructor overloading");
        System.out.println("• Method resolution happens at compile time");
        System.out.println("• Based on method signature (name, parameters)");
        System.out.println("• Faster execution (no runtime overhead)");
        System.out.println("• Example: add(int, int) vs add(double, double)");

        System.out.println("\nRUNTIME POLYMORPHISM:");
        System.out.println("• Also called Dynamic Polymorphism");
        System.out.println("• Achieved through method overriding and interfaces");
        System.out.println("• Method resolution happens at runtime");
        System.out.println("• Based on actual object type (Dynamic Method Dispatch)");
        System.out.println("• Slightly slower (runtime method lookup)");
        System.out.println("• Example: Shape reference calling Circle.calculateArea()");
        System.out.println("• Enables true object-oriented design principles");

        System.out.println("\n" + "=".repeat(80));
        System.out.println("DEMONSTRATION COMPLETE");
        System.out.println("=".repeat(80));
    }

    // Method to demonstrate runtime polymorphism
    public static void demonstratePolymorphism(Shape shape) {
        System.out.println("\nDemonstrating polymorphism with " + shape.getClass().getSimpleName() + ":");
        System.out.println("Area calculation: " + shape.calculateArea());

        // instanceof check for safe casting
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            System.out.println("Circle-specific method - Diameter: " + circle.getDiameter());
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            System.out.println("Rectangle-specific method - Is Square: " + rectangle.isSquare());
        }
    }
}