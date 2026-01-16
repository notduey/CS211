package week01.lab.animal;

public abstract class Animal {
    public abstract void makeSound(); // abstract method, no implementation, must be overridden

    public void sleep() {
        System.out.println("This animal is sleeping.");
    }
}
