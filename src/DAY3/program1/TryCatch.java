package DAY3.program1;

// 🛠️ Step 1: Custom exception class
class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}

// 🚀 Step 2: Main class
public class TryCatch {

    // 🧠 Method that throws a custom exception if age < 18
    public static void checkEligibility(int age) throws UnderAgeException {
        if (age < 18) {
            throw new UnderAgeException("❌ You must be at least 18 to vote!");
        } else {
            System.out.println("✅ You're eligible to vote!");
        }
    }

    public static void main(String[] args) {
        // 🤖 Part 1: Handling runtime exceptions using try-catch
        try {
            int[] nums = {10, 20, 30};
            System.out.println("🧮 Value at index 1: " + nums[1]);

            int result = nums[1] / 0; // 💥 Division by zero (runtime error)
            System.out.println("Result: " + result);

        } catch (ArithmeticException ae) {
            System.out.println("⚠️ Arithmetic Error: " + ae.getMessage());
        } catch (ArrayIndexOutOfBoundsException aioe) {
            System.out.println("⚠️ Array Index Error: " + aioe.getMessage());
        } catch (Exception e) {
            System.out.println("⚠️ Some other error: " + e);
        }

        System.out.println("📌 Runtime error part handled gracefully!\n");

        // 🤖 Part 2: Handling custom exception
        try {
            int userAge = 16; // 👶 Change to 20 to test valid case
            checkEligibility(userAge); // 🧪 Method that may throw custom error
        } catch (UnderAgeException uae) {
            System.out.println("🚫 Custom Exception: " + uae.getMessage());
        }

        System.out.println("🚀 Program finished like a pro 😎");
    }
}
