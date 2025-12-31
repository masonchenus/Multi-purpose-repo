// Classes in Java - Comprehensive OOP Examples
public class Classes {
    
    public static void main(String[] args) {
        // Create instances of different classes
        Person person = new Person("John", 30, "Engineer");
        Student student = new Student("Alice", 20, "Computer Science", 3.8);
        Employee employee = new Employee("Bob", 35, "Software Developer", 75000);
        
        // Display information
        person.displayInfo();
        System.out.println();
        
        student.displayInfo();
        student.study();
        System.out.println();
        
        employee.displayInfo();
        employee.work();
        
        // Inheritance demonstration
        Vehicle car = new Car("Toyota", "Camry", 2022);
        Vehicle motorcycle = new Motorcycle("Honda", "CBR", 2021);
        
        car.start();
        car.stop();
        motorcycle.start();
        motorcycle.stop();
    }
}

// Base class
class Person {
    protected String name;
    protected int age;
    protected String profession;
    
    public Person(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Profession: " + profession);
    }
}

// Derived class
class Student extends Person {
    private String major;
    private double gpa;
    
    public Student(String name, int age, String major, double gpa) {
        super(name, age, "Student");
        this.major = major;
        this.gpa = gpa;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
    }
    
    public void study() {
        System.out.println(name + " is studying " + major);
    }
}

// Another derived class
class Employee extends Person {
    private String position;
    private double salary;
    
    public Employee(String name, int age, String position, double salary) {
        super(name, age, "Employee");
        this.position = position;
        this.salary = salary;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Position: " + position);
        System.out.println("Salary: $" + salary);
    }
    
    public void work() {
        System.out.println(name + " is working as a " + position);
    }
}

// Base class for vehicles
class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    public void start() {
        System.out.println("Starting " + make + " " + model);
    }
    
    public void stop() {
        System.out.println("Stopping " + make + " " + model);
    }
}

// Derived class for cars
class Car extends Vehicle {
    public Car(String make, String model, int year) {
        super(make, model, year);
    }
    
    @Override
    public void start() {
        System.out.println("Car " + make + " " + model + " is starting with key ignition");
    }
}

// Derived class for motorcycles
class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year) {
        super(make, model, year);
    }
    
    @Override
    public void start() {
        System.out.println("Motorcycle " + make + " " + model + " is starting with kick start");
    }
}
