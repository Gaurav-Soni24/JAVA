package DAY3.program2;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";

        // 🔥 String concatenation
        String result = str1 + " " + str2;
        System.out.println("Concatenated: " + result);

        // 💥 Length of string
        System.out.println("Length of str1: " + str1.length());

        // 🎯 Character at a specific index
        System.out.println("Char at index 1 in str1: " + str1.charAt(1));

        // 🧠 Compare strings
        System.out.println("Are they equal? " + str1.equals(str2));

        // 💫 Substring
        System.out.println("Substring of str2: " + str2.substring(1, 4));

        // 🔄 Convert to uppercase
        System.out.println("Uppercase str1: " + str1.toUpperCase());

        // 🔁 Replace characters
        System.out.println("Replace l with x in str1: " + str1.replace('l', 'x'));
    }
}
