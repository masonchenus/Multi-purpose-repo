// File I/O in Java
import java.io.*;
import java.nio.file.*;

public class FileIO {
    
    public static void main(String[] args) {
        
        String fileName = "test.txt";
        
        // Writing to a file using FileWriter
        System.out.println("Writing to file using FileWriter:");
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, World!\n");
            writer.write("This is a test file.\n");
            writer.write("Java File I/O is powerful.");
            System.out.println("Successfully wrote to file");
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
        }
        
        // Reading from a file using FileReader
        System.out.println("\nReading from file using FileReader:");
        try (FileReader reader = new FileReader(fileName)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading: " + e.getMessage());
        }
        
        // Using BufferedReader for efficient reading
        System.out.println("\nReading with BufferedReader:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading: " + e.getMessage());
        }
        
        // Using BufferedWriter for efficient writing
        System.out.println("\nWriting with BufferedWriter:");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine();
            writer.write("Appended line using BufferedWriter");
            System.out.println("Successfully appended to file");
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
        }
        
        // Using Files class (Java 7+)
        System.out.println("\nUsing Files class:");
        try {
            // Read all lines
            System.out.println("Reading all lines:");
            Files.lines(Paths.get(fileName)).forEach(System.out::println);
            
            // Read entire file as string
            String content = Files.readString(Paths.get(fileName));
            System.out.println("\nFile content length: " + content.length() + " characters");
            
            // Check if file exists
            System.out.println("File exists: " + Files.exists(Paths.get(fileName)));
            
            // Get file size
            System.out.println("File size: " + Files.size(Paths.get(fileName)) + " bytes");
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Object serialization
        System.out.println("\nObject serialization:");
        Person person = new Person("John", 30);
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
            System.out.println("Object serialized successfully");
        } catch (IOException e) {
            System.out.println("Error serializing: " + e.getMessage());
        }
        
        // Object deserialization
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Object deserialized: " + deserializedPerson.name + ", " + deserializedPerson.age);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializing: " + e.getMessage());
        }
        
        // Clean up
        new File("person.ser").delete();
    }
}

// Serializable class
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
