package program2;

class ArithmeticOperators {

    public void add(int a, int b) {
        System.out.println(a + b);
    }

    public void sub(int a, int b) {
        System.out.println(a - b);
    }

    public void mul(int a, int b) {
        System.out.println(a * b);
    }

    public void div(int a, int b) {
        if (b != 0) {
            System.out.println(a / b);
        } else {
            System.out.println("Division by zero is not allowed");
        }
    }

    public void mod(int a, int b) {
        if (b != 0) {
            System.out.println(a % b);
        } else {
            System.out.println("Modulo by zero is not allowed");
        }
    }
}

class RelationalOperators {

    public boolean greaterThan(int a, int b) {
        return a > b;
    }

    public boolean smallerThan(int a, int b) {
        return a < b;
    }

    public boolean greaterThanEqualTo(int a, int b) {
        return a >= b;
    }

    public boolean smallerThanEqualTo(int a, int b) {
        return a <= b;
    }

    public boolean equalTo(int a, int b) {
        return a == b;
    }

    public boolean notEqualTo(int a, int b) {
        return a != b;
    }
}

class LogicalOperators {

    public boolean logicalAnd(boolean a, boolean b) {
        return a && b;
    }

    public boolean logicalOr(boolean a, boolean b) {
        return a || b;
    }

    public boolean logicalNot(boolean a) {
        return !a;
    }
}

class AssignmentOperators {

    public void simpleAssignment(int value) {
        int x = value;
        System.out.println("Simple assignment (=): " + x);
    }

    public void addAssignment(int x, int value) {
        x += value;
        System.out.println("Add assignment (+=): " + x);
    }

    public void subAssignment(int x, int value) {
        x -= value;
        System.out.println("Subtract assignment (-=): " + x);
    }

    public void mulAssignment(int x, int value) {
        x *= value;
        System.out.println("Multiply assignment (*=): " + x);
    }

    public void divAssignment(int x, int value) {
        if (value != 0) {
            x /= value;
            System.out.println("Divide assignment (/=): " + x);
        } else {
            System.out.println("Division by zero is not allowed");
        }
    }

    public void modAssignment(int x, int value) {
        if (value != 0) {
            x %= value;
            System.out.println("Modulo assignment (%=): " + x);
        } else {
            System.out.println("Modulo by zero is not allowed");
        }
    }
}

class UnaryOperators {

    public void incrementOperators(int x) {
        System.out.println("Original value: " + x);
        System.out.println("Pre-increment (++x): " + (++x));
        x = 5; // Reset
        System.out.println("Post-increment (x++): " + (x++));
        System.out.println("After post-increment: " + x);
    }

    public void decrementOperators(int x) {
        System.out.println("Original value: " + x);
        System.out.println("Pre-decrement (--x): " + (--x));
        x = 5; // Reset
        System.out.println("Post-decrement (x--): " + (x--));
        System.out.println("After post-decrement: " + x);
    }

    public void unaryPlusMinusOperators(int x) {
        System.out.println("Unary plus (+x): " + (+x));
        System.out.println("Unary minus (-x): " + (-x));
    }
}

class BitwiseOperators {

    public void bitwiseAnd(int a, int b) {
        System.out.println("Bitwise AND (&): " + (a & b));
    }

    public void bitwiseOr(int a, int b) {
        System.out.println("Bitwise OR (|): " + (a | b));
    }

    public void bitwiseXor(int a, int b) {
        System.out.println("Bitwise XOR (^): " + (a ^ b));
    }

    public void bitwiseComplement(int a) {
        System.out.println("Bitwise Complement (~): " + (~a));
    }

    public void leftShift(int a, int positions) {
        System.out.println("Left Shift (<<): " + (a << positions));
    }

    public void rightShift(int a, int positions) {
        System.out.println("Right Shift (>>): " + (a >> positions));
    }

    public void unsignedRightShift(int a, int positions) {
        System.out.println("Unsigned Right Shift (>>>): " + (a >>> positions));
    }
}

class TernaryOperator {

    public void conditionalOperator(int a, int b) {
        int max = (a > b) ? a : b;
        System.out.println("Maximum using ternary operator: " + max);

        String result = (a == b) ? "Equal" : "Not Equal";
        System.out.println("Equality check: " + result);
    }
}

public class OperatorInJava {

    public static void main(String[] args) {
        int a = 20;
        int b = 10;

        System.out.println("=== OPERATOR DEMONSTRATION IN JAVA ===");
        System.out.println("Value of a: " + a);
        System.out.println("Value of b: " + b);

        // Arithmetic Operators
        System.out.println("\n--- ARITHMETIC OPERATORS ---");
        ArithmeticOperators arithmeticOperators = new ArithmeticOperators();
        System.out.print("Addition: ");
        arithmeticOperators.add(a, b);
        System.out.print("Subtraction: ");
        arithmeticOperators.sub(a, b);
        System.out.print("Multiplication: ");
        arithmeticOperators.mul(a, b);
        System.out.print("Division: ");
        arithmeticOperators.div(a, b);
        System.out.print("Modulo: ");
        arithmeticOperators.mod(a, b);

        // Relational Operators
        System.out.println("\n--- RELATIONAL OPERATORS ---");
        RelationalOperators relationalOperators = new RelationalOperators();
        System.out.println("Greater than (>): " + relationalOperators.greaterThan(a, b));
        System.out.println("Smaller than (<): " + relationalOperators.smallerThan(a, b));
        System.out.println("Greater than or equal (>=): " + relationalOperators.greaterThanEqualTo(a, b));
        System.out.println("Smaller than or equal (<=): " + relationalOperators.smallerThanEqualTo(a, b));
        System.out.println("Equal to (==): " + relationalOperators.equalTo(a, b));
        System.out.println("Not equal to (!=): " + relationalOperators.notEqualTo(a, b));

        // Logical Operators
        System.out.println("\n--- LOGICAL OPERATORS ---");
        LogicalOperators logicalOperators = new LogicalOperators();
        boolean x = true, y = false;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("Logical AND (&&): " + logicalOperators.logicalAnd(x, y));
        System.out.println("Logical OR (||): " + logicalOperators.logicalOr(x, y));
        System.out.println("Logical NOT (!x): " + logicalOperators.logicalNot(x));
        System.out.println("Logical NOT (!y): " + logicalOperators.logicalNot(y));

        // Assignment Operators
        System.out.println("\n--- ASSIGNMENT OPERATORS ---");
        AssignmentOperators assignmentOperators = new AssignmentOperators();
        assignmentOperators.simpleAssignment(15);
        assignmentOperators.addAssignment(10, 5);
        assignmentOperators.subAssignment(20, 8);
        assignmentOperators.mulAssignment(4, 3);
        assignmentOperators.divAssignment(15, 3);
        assignmentOperators.modAssignment(17, 5);

        // Unary Operators
        System.out.println("\n--- UNARY OPERATORS ---");
        UnaryOperators unaryOperators = new UnaryOperators();
        System.out.println("Increment Operators:");
        unaryOperators.incrementOperators(5);
        System.out.println("\nDecrement Operators:");
        unaryOperators.decrementOperators(5);
        System.out.println("\nUnary Plus/Minus Operators:");
        unaryOperators.unaryPlusMinusOperators(7);

        // Bitwise Operators
        System.out.println("\n--- BITWISE OPERATORS ---");
        BitwiseOperators bitwiseOperators = new BitwiseOperators();
        int num1 = 12;
        int num2 = 10;
        System.out.println("num1 = " + num1 + " (Binary: " + Integer.toBinaryString(num1) + ")");
        System.out.println("num2 = " + num2 + " (Binary: " + Integer.toBinaryString(num2) + ")");
        bitwiseOperators.bitwiseAnd(num1, num2);
        bitwiseOperators.bitwiseOr(num1, num2);
        bitwiseOperators.bitwiseXor(num1, num2);
        bitwiseOperators.bitwiseComplement(num1);
        bitwiseOperators.leftShift(num1, 2);
        bitwiseOperators.rightShift(num1, 2);
        bitwiseOperators.unsignedRightShift(-8, 2);

        // Ternary Operator
        System.out.println("\n--- TERNARY OPERATOR ---");
        TernaryOperator ternaryOperator = new TernaryOperator();
        ternaryOperator.conditionalOperator(a, b);
        ternaryOperator.conditionalOperator(15, 15);
    }
}