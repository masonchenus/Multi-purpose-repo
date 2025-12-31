// Loops in Java
public class Loops {
    
    public static void main(String[] args) {
        
        // For loop
        System.out.println("For loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }
        
        // Enhanced for loop (for-each)
        String[] fruits = {"Apple", "Banana", "Cherry", "Date"};
        System.out.println("\nEnhanced for loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        // While loop
        System.out.println("\nWhile loop:");
        int count = 0;
        while (count < 5) {
            System.out.println("Count: " + count);
            count++;
        }
        
        // Do-while loop
        System.out.println("\nDo-while loop:");
        int num = 0;
        do {
            System.out.println("Number: " + num);
            num++;
        } while (num < 5);
        
        // Nested loops
        System.out.println("\nNested loops (multiplication table):");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i + " x " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
        
        // Break statement
        System.out.println("\nBreak example:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break;
            }
            System.out.println("i = " + i);
        }
        
        // Continue statement
        System.out.println("\nContinue example (skip odd numbers):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 1) {
                continue;
            }
            System.out.println("i = " + i);
        }
        
        // Labeled break
        outerLoop:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break outerLoop;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        
        // For-each with break using labeled break
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Purple"};
        System.out.println("\nFor-each with break:");
        colorLoop:
        for (String color : colors) {
            if (color.equals("Blue")) {
                break;
            }
            System.out.println(color);
        }
    }
}
