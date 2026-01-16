//============================================================
// CSE143 PREP NOTES — INHERITANCE & INTERFACES
//============================================================
//
// This chapter is about RELATIONSHIPS between classes.
//
// Instead of designing one class well,
// we now design FAMILIES of related classes.
//
// Inheritance and interfaces are critical for:
// - Polymorphism
// - Clean design
// - Data structures (lists, trees, etc.)
//
// If encapsulation protects objects,
// inheritance connects them.
//============================================================



//------------------------------------------------------------
// 1. INHERITANCE (CORE IDEA)
//------------------------------------------------------------
//
// Inheritance allows one class to be based on another class.
//
// One class EXTENDS another.
//
// Vocabulary:
// - Superclass (parent): class being extended
// - Subclass (child): class that extends the superclass
//
// Inheritance creates an IS-A relationship.
//
// Examples:
// - Dog IS-A Animal
// - Student IS-A Person
// - ArrayList IS-A List
//
// Inheritance is used to:
// - Share code
// - Avoid duplication
// - Group related objects
//------------------------------------------------------------



//------------------------------------------------------------
// 2. INHERITANCE SYNTAX
//------------------------------------------------------------

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name; // superclass initializes its own fields
    }

    public void speak() {
        System.out.println("..."); // default behavior
    }
}

// The keyword `extends` creates a subclass.
// The subclass automatically inherits public methods.

public class Dog extends Animal {
    private int age;

    public Dog(String name, int age) {
        super(name);      // REQUIRED: calls Animal constructor first
        this.age = age;   // subclass initializes its own fields
    }

    public void speak() {
        System.out.println("Woof"); // overrides Animal.speak()
    }
}



//------------------------------------------------------------
// 3. SUPERCLASS CONSTRUCTORS & super
//------------------------------------------------------------
//
// VERY IMPORTANT RULE:
// A subclass constructor MUST call a superclass constructor.
//
// Why?
// - The superclass owns its fields
// - Only the superclass knows how to initialize them correctly
//
// Rules for super(...):
// - Must be the FIRST line in the constructor
// - Passes values up to the parent
//
// If you forget super(...), your code will NOT compile
// (unless the superclass has a no-arg constructor).
//------------------------------------------------------------



//------------------------------------------------------------
// 4. METHOD OVERRIDING
//------------------------------------------------------------
//
// Overriding means:
// - Subclass provides its OWN version of a superclass method
//
// Rules for overriding:
// - Same method name
// - Same parameter list
// - Same return type
// - Access level cannot be more restrictive
//
// Overriding enables polymorphism.

public class Cat extends Animal {

    public Cat(String name) {
        super(name); // call parent constructor
    }

    public void speak() {
        System.out.println("Meow"); // replaces Animal.speak()
    }
}



//------------------------------------------------------------
// 5. THE Object CLASS
//------------------------------------------------------------
//
// In Java, ALL classes inherit from Object.
// Even if you do not write `extends Object`.
//
// Object provides important methods:
// - toString()
// - equals(Object)
// - getClass()
//
// These methods often need to be overridden,
// because the default versions are usually not useful.
//------------------------------------------------------------



//------------------------------------------------------------
// 6. == VS equals()
//------------------------------------------------------------
//
// == compares MEMORY ADDRESSES for objects.
// equals() compares MEANING (if implemented properly).
//
// == asks:
// - "Are these two references pointing to the same object?"
//
// equals() asks:
// - "Do these two objects represent the same value?"

Point p1 = new Point(7, 2);
Point p2 = new Point(7, 2);

p1 == p2;        // false → different objects in memory
p1.equals(p2);   // true or false depending on equals implementation



//------------------------------------------------------------
// 7. instanceof (TYPE CHECKING)
//------------------------------------------------------------
//
// instanceof checks whether an object is a certain type
// or a subclass of that type.
//
// Used to:
// - Prevent invalid casts
// - Safely work with subclass-specific behavior

if (animal instanceof Dog) {        // check before casting
    Dog d = (Dog) animal;            // safe cast after instanceof
    d.speak();                       // can now use Dog behavior
}

// Rule:
// - ALWAYS check instanceof before casting.
//------------------------------------------------------------



//------------------------------------------------------------
// 8. POLYMORPHISM (CORE CSE143 IDEA)
//------------------------------------------------------------
//
// Polymorphism means:
// - "Same code, different behavior"
//
// A variable of a superclass type can refer to
// objects of any subclass.
//
// Method calls are resolved at RUNTIME,
// based on the actual object type.

Animal a1 = new Dog("Buddy", 5);   // variable type: Animal, object: Dog
Animal a2 = new Cat("Whiskers");   // variable type: Animal, object: Cat

a1.speak();  // Woof → Dog.speak() runs
a2.speak();  // Meow → Cat.speak() runs

// KEY RULE (EXAM FAVORITE):
// - The method that runs depends on the OBJECT,
//   not the variable type.
//------------------------------------------------------------



//------------------------------------------------------------
// 9. POLYMORPHISM WITH ARRAYS
//------------------------------------------------------------
//
// Arrays (and collections later) can store superclass types.
// Each element may be a different subclass.

Animal[] animals = {
    new Dog("Lucky", 3),
    new Cat("Milo"),
    new Dog("Rex", 7)
};

for (Animal a : animals) {
    a.speak();  // each object responds with its own behavior
}

// Same loop, different outputs → polymorphism.
//------------------------------------------------------------



//------------------------------------------------------------
// 10. LIMITATION OF INHERITANCE
//------------------------------------------------------------
//
// Java supports ONLY SINGLE INHERITANCE.
// A class can extend ONE superclass only.
//
// Problem:
// - What if a class needs multiple "IS-A" relationships?
//
// Solution:
// - INTERFACES.
//------------------------------------------------------------



//------------------------------------------------------------
// 11. INTERFACES (WHAT THEY ARE)
//------------------------------------------------------------
//
// An interface defines WHAT a class can do,
// but NOT how it does it.
//
// Interfaces:
// - Contain method declarations only
// - Have no instance fields
// - Allow multiple inheritance of behavior contracts
//------------------------------------------------------------



//------------------------------------------------------------
// 12. INTERFACE SYNTAX
//------------------------------------------------------------

public interface Flyable {
    void fly(); // method declaration only
}

public class Bird extends Animal implements Flyable {

    public Bird(String name) {
        super(name); // initialize Animal part
    }

    public void fly() {
        System.out.println("Flapping wings"); // required implementation
    }
}

// Interface rules:
// - A class can implement MULTIPLE interfaces
// - Must implement ALL methods
// - Uses keyword `implements`
//------------------------------------------------------------



//------------------------------------------------------------
// 13. ABSTRACT CLASSES
//------------------------------------------------------------
//
// An abstract class is a mix between:
// - A concrete class
// - An interface
//
// Abstract classes:
// - Can have fields
// - Can have implemented methods
// - Can have abstract methods
// - CANNOT be instantiated

public abstract class Shape {

    public abstract double area(); // must be implemented by subclasses

    public void describe() {
        System.out.println("I am a shape"); // shared behavior
    }
}

public class Circle extends Shape {
    private double radius;

    public Circle(double r) {
        radius = r;
    }

    public double area() {
        return Math.PI * radius * radius; // concrete implementation
    }
}



//------------------------------------------------------------
// 14. OVERLOADING VS OVERRIDING (EXAM FAVORITE)
//------------------------------------------------------------
//
// Overloading:
// - Same method name
// - Different parameters
// - Same class
// - Compile-time decision
//
// Overriding:
// - Same method signature
// - Subclass replaces behavior
// - Runtime decision
//------------------------------------------------------------



//------------------------------------------------------------
// 15. CSE143 TAKEAWAYS
//------------------------------------------------------------
//
// 1) Inheritance models IS-A relationships
// 2) Subclasses must call super constructors
// 3) Overridden methods enable polymorphism
// 4) == compares references, equals compares meaning
// 5) instanceof protects against invalid casts
// 6) Interfaces allow multiple inheritance
// 7) Polymorphism is resolved at runtime
//------------------------------------------------------------