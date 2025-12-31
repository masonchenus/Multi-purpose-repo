// Object-Oriented Programming in Java
public class OOP {
    
    public static void main(String[] args) {
        // Creating objects
        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        
        dog.makeSound();
        cat.makeSound();
        
        // Using abstract class
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
    }
}

// Interface
interface Animal {
    void makeSound();
    void move();
}

// Abstract class
abstract class Shape {
    protected String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    public abstract double calculateArea();
    
    public void displayInfo() {
        System.out.println("Shape: " + name);
    }
}

// Concrete class implementing interface
class Dog implements Animal {
    private String name;
    private int age;
    
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " is running");
    }
}

class Cat implements Animal {
    private String name;
    private int age;
    
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " is walking");
    }
}

// Classes extending abstract class
class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}
