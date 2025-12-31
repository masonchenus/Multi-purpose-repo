// Conditionals in Java
public class Conditionals {
    
    public static void main(String[] args) {
        int number = 10;
        String day = "Monday";
        
        // Simple if statement
        System.out.println("Simple if:");
        if (number > 0) {
            System.out.println("Number is positive");
        }
        
        // if-else statement
        System.out.println("\nIf-else:");
        if (number % 2 == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }
        
        // if-else if-else chain
        System.out.println("\nIf-else if-else:");
        if (number < 0) {
            System.out.println("Number is negative");
        } else if (number == 0) {
            System.out.println("Number is zero");
        } else {
            System.out.println("Number is positive");
        }
        
        // Nested if statements
        System.out.println("\nNested if:");
        int age = 25;
        boolean hasLicense = true;
        
        if (age >= 18) {
            System.out.println("Eligible for driving test");
            if (hasLicense) {
                System.out.println("Can drive immediately");
            } else {
                System.out.println("Needs to get license");
            }
        } else {
            System.out.println("Too young to drive");
        }
        
        // Switch statement (traditional)
        System.out.println("\nSwitch statement:");
        switch (day) {
            case "Monday":
                System.out.println("Start of the work week");
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                System.out.println("Regular work day");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("Invalid day");
        }
        
        // Switch expression (Java 14+)
        System.out.println("\nSwitch expression:");
        String result = switch (day) {
            case "Monday" -> "Start of the work week";
            case "Friday" -> "End of the work week";
            case "Saturday", "Sunday" -> "Weekend!";
            default -> "Regular work day";
        };
        System.out.println(result);
        
        // Ternary operator
        System.out.println("\nTernary operator:");
        String status = (number >= 0) ? "Non-negative" : "Negative";
        System.out.println("Status: " + status);
        
        // Complex conditionals with logical operators
        System.out.log("\nComplex conditionals:");
        int score = 85;
        String grade;
        
        if (score >= 90 && score <= 100) {
            grade = "A";
        } else if (score >= 80 && score < 90) {
            grade = "B";
        } else if (score >= 70 && score < 80) {
            grade = "C";
        } else if (score >= 60 && score < 70) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Grade: " + grade);
    }
}
