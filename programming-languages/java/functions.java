// Functions in Java
public class Functions {
    
    // Static method
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Instance method
    public int multiply(int a, int b) {
        return a * b;
    }
    
    // Method with variable arguments
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    
    // Generic method
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    // Lambda expression (Java 8+)
    public static void lambdaExample() {
        // Simple lambda
        Runnable runnable = () -> System.out.println("Running lambda!");
        runnable.run();
        
        // Lambda with parameters
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        
        System.out.println("10 + 5 = " + addition.operate(10, 5));
        System.out.println("10 - 5 = " + subtraction.operate(10, 5));
    }
    
    // Functional interface
    interface MathOperation {
        int operate(int a, int b);
    }
    
    public static void main(String[] args) {
        // Calling static methods
        System.out.println("Add: " + add(10, 5));
        System.out.println("Sum: " + sum(1, 2, 3, 4, 5));
        
        // Calling instance method
        Functions obj = new Functions();
        System.out.println("Multiply: " + obj.multiply(10, 5));
        
        // Lambda example
        lambdaExample();
    }
}
