// Functional Programming in Java (Java 8+)
import java.util.*;
import java.util.stream.*;

public class Functional {
    
    public static void main(String[] args) {
        
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Using streams - map
        System.out.println("Stream map - doubling numbers:");
        List<Integer> doubled = numbers.stream()
            .map(n -> n * 2)
            .collect(Collectors.toList());
        System.out.println(doubled);
        
        // Using streams - filter
        System.out.println("\nStream filter - even numbers:");
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println(evenNumbers);
        
        // Using streams - reduce
        System.out.println("\nStream reduce - sum of all numbers:");
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        
        // Using streams - collect
        System.out.println("\nStream collect - to set:");
        Set<Integer> uniqueSquares = numbers.stream()
            .map(n -> n * n)
            .collect(Collectors.toSet());
        System.out.println(uniqueSquares);
        
        // Using streams - forEach
        System.out.println("\nStream forEach - print each number:");
        numbers.stream()
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Using streams - sorted
        System.out.println("\nStream sorted:");
        List<Integer> shuffled = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3));
        shuffled.stream()
            .sorted()
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Using streams - distinct
        System.out.println("\nStream distinct:");
        List<Integer> withDuplicates = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        withDuplicates.stream()
            .distinct()
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Using streams - limit and skip
        System.out.println("\nStream limit and skip:");
        numbers.stream()
            .skip(2)
            .limit(5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Using Optional
        System.out.println("\nUsing Optional:");
        Optional<String> emptyOpt = Optional.empty();
        Optional<String> presentOpt = Optional.of("Hello");
        
        System.out.println("Empty: " + emptyOpt.orElse("Default"));
        System.out.println("Present: " + presentOpt.orElse("Default"));
        
        // Method references
        System.out.println("\nMethod references:");
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        words.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);
        
        // Stream of
        System.out.println("\nStream.of():");
        Stream.of("A", "B", "C", "D", "E")
            .filter(s -> s.compareTo("C") > 0)
            .forEach(System.out::println);
        
        // IntStream, LongStream, DoubleStream
        System.out.println("\nIntStream range:");
        IntStream.range(1, 6)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Statistics with streams
        System.out.println("\nStream statistics:");
        IntSummaryStatistics stats = numbers.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
        
        // Parallel streams
        System.out.println("\nParallel stream:");
        long startTime = System.currentTimeMillis();
        long parallelSum = numbers.parallelStream()
            .reduce(0, Integer::sum);
        long parallelTime = System.currentTimeMillis() - startTime;
        System.out.println("Parallel sum: " + parallelSum + " (took " + parallelTime + "ms)");
        
        startTime = System.currentTimeMillis();
        long sequentialSum = numbers.stream()
            .reduce(0, Integer::sum);
        long sequentialTime = System.currentTimeMillis() - startTime;
        System.out.println("Sequential sum: " + sequentialSum + " (took " + sequentialTime + "ms)");
    }
}
