// Error Handling in Java
public class ErrorHandling {
    
    public static void main(String[] args) {
        
        // Basic try-catch
        System.out.println("Basic try-catch:");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
        
        // Multiple catch blocks
        System.out.println("\nMultiple catch blocks:");
        try {
            int[] array = new int[5];
            System.out.println(array[10]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught general exception: " + e.getMessage());
        }
        
        // Try-with-resources
        System.out.println("\nTry-with-resources:");
        try (java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.StringReader("Hello from try-with-resources"))) {
            String line = reader.readLine();
            System.out.println("Read: " + line);
        } catch (java.io.IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        
        // Custom exception
        System.out.println("\nCustom exception:");
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Caught InvalidAgeException: " + e.getMessage());
        }
        
        // Finally block
        System.out.println("\nFinally block:");
        try {
            System.out.println("Inside try block");
        } catch (Exception e) {
            System.out.println("Inside catch block");
        } finally {
            System.out.println("Finally block always executes");
        }
        
        // Nested try-catch
        System.out.println("\nNested try-catch:");
        try {
            try {
                String text = null;
                System.out.println(text.length());
            } catch (NullPointerException e) {
                System.out.println("Inner catch: NullPointerException");
                throw new RuntimeException("rethrown exception", e);
            }
        } catch (RuntimeException e) {
            System.out.println("Outer catch: RuntimeException");
            System.out.println("Caused by: " + e.getCause());
        }
    }
    
    // Method throwing custom exception
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older");
        }
        System.out.println("Age is valid");
    }
}

// Custom exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
