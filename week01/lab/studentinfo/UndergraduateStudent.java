package week01.lab.studentinfo;

public class UndergraduateStudent extends Student {
    private int year;
    
    public UndergraduateStudent(String name) {
        // super calls constructor of parent class, in this case the Student class
        super(name, 18);
        year = 0;
    }

    @Override // method overrides the same method in the parent class
    public void setAge(int age) {
        super.setAge(age); // calls parent class's method
        year++;
    }
}
