// Arrays in Java
public class Arrays {
    
    public static void main(String[] args) {
        // Declaring and initializing arrays
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};
        double[] prices = {19.99, 29.99, 39.99, 49.99};
        
        // Basic array operations
        System.out.println("Array length: " + numbers.length);
        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length - 1]);
        
        // Iterating through arrays
        System.out.println("\nAll numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        // Enhanced for loop
        System.out.println("\nAll names:");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
        
        // Multidimensional arrays
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("\n2D Array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Array manipulation
        int[] copiedArray = numbers.clone();
        System.out.println("\nCloned array:");
        for (int num : copiedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Arrays utility class methods
        java.util.Arrays.sort(numbers);
        System.out.println("\nSorted numbers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Binary search
        int index = java.util.Arrays.binarySearch(numbers, 5);
        System.out.println("\nIndex of 5: " + index);
        
        // Fill array
        int[] filledArray = new int[5];
        java.util.Arrays.fill(filledArray, 42);
        System.out.println("\nFilled array:");
        for (int num : filledArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Compare arrays
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        System.out.println("\nArrays equal: " + java.util.Arrays.equals(array1, array2));
    }
}
