// Regular Expressions in Java
import java.util.regex.*;

public class Regex {
    
    public static void main(String[] args) {
        
        String text = "Contact us at: email@example.com or support@company.org";
        String phoneText = "Phone: 123-456-7890, Mobile: (987) 654-3210";
        
        // Pattern and Matcher
        System.out.println("Using Pattern and Matcher:");
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");
        Matcher matcher = emailPattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println("Found email: " + matcher.group());
        }
        
        // Using String matches()
        System.out.println("\nUsing String.matches():");
        String email1 = "test@example.com";
        String email2 = "invalid-email";
        System.out.println(email1 + " is valid email: " + email1.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}"));
        System.out.println(email2 + " is valid email: " + email2.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}"));
        
        // Phone number validation
        System.out.println("\nPhone number validation:");
        Pattern phonePattern = Pattern.compile("\\(?(\\d{3})\\)?[-. ]?(\\d{3})[-. ]?(\\d{4})");
        Matcher phoneMatcher = phonePattern.matcher(phoneText);
        
        while (phoneMatcher.find()) {
            System.out.println("Found phone: " + phoneMatcher.group());
        }
        
        // Pattern flags
        System.out.println("\nUsing pattern flags:");
        String caseSensitive = "Hello hello HELLO";
        Pattern pattern1 = Pattern.compile("hello");
        Pattern pattern2 = Pattern.compile("hello", Pattern.CASE_INSENSITIVE);
        
        System.out.println("Case sensitive matches:");
        Matcher matcher1 = pattern1.matcher(caseSensitive);
        while (matcher1.find()) {
            System.out.println("Found: " + matcher1.group());
        }
        
        System.out.println("\nCase insensitive matches:");
        Matcher matcher2 = pattern2.matcher(caseSensitive);
        while (matcher2.find()) {
            System.out.println("Found: " + matcher2.group());
        }
        
        // String replacement
        System.out.println("\nString replacement:");
        String original = "The quick brown fox jumps over the lazy dog";
        String replaced = original.replace("fox", "cat");
        System.out.println("Original: " + original);
        System.out.println("Replaced: " + replaced);
        
        // Using replaceAll with regex
        String withNumbers = "Order #12345 for item ABC at price $99.99";
        String cleaned = withNumbers.replaceAll("#\\d+", "#XXXXX");
        System.out.println("\nCleaned: " + cleaned);
        
        // Splitting strings
        System.out.println("\nSplitting strings:");
        String csv = "apple,banana,cherry,date";
        String[] fruits = csv.split(",");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        // Complex regex pattern
        System.out.println("\nComplex pattern - URL validation:");
        String urlPattern = "^(https?://)?([\\w\\.-]+\\.)+[a-z]{2,6}(/[\\w\\.-]*)*/?$";
        String[] urls = {"https://www.example.com", "invalid-url", "http://sub.domain.co.uk/path"};
        for (String url : urls) {
            System.out.println(url + ": " + url.matches(urlPattern));
        }
        
        // Named groups (Java 8+)
        System.out.println("\nNamed groups:");
        Pattern namedPattern = Pattern.compile("(?<area>\\d{3})[-](?<prefix>\\d{3})[-](?<number>\\d{4})");
        Matcher namedMatcher = namedPattern.matcher("Phone: 555-123-4567");
        if (namedMatcher.find()) {
            System.out.println("Area code: " + namedMatcher.group("area"));
            System.out.println("Prefix: " + namedMatcher.group("prefix"));
            System.out.println("Number: " + namedMatcher.group("number"));
        }
    }
}
