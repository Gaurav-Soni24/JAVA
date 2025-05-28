package DAY3.program2;

public class StringBuilderDemo {
    public static void main(String[] args) {
        String original = "Level";

        // 🔁 Reverse a string using StringBuilder
        String reversed = new StringBuilder(original).reverse().toString();
        System.out.println("🔄 Reversed: " + reversed);

        // 🔍 Check for palindrome (case-insensitive)
        if (original.equalsIgnoreCase(reversed)) {
            System.out.println("✅ '" + original + "' is a Palindrome!");
        } else {
            System.out.println("❌ '" + original + "' is NOT a Palindrome.");
        }

        // 🧱 Using StringBuilder for efficient string manipulation
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming 💻");
        sb.insert(0, "🔥 ");
        sb.replace(5, 9, "Super");
        sb.delete(0, 2);

        System.out.println("🧠 StringBuilder magic: " + sb);

        // 🧱 StringBuffer example (thread-safe version of StringBuilder)
        StringBuffer sbf = new StringBuffer("Thread");
        sbf.append(" Safe 🔒");
        System.out.println("🛡️ StringBuffer: " + sbf);
    }

}
