package week01.lab.studentcompare;

public class Student implements Comparable<Student> { 
    //Comparable<Student> lets Students by sorted (compareTo defines order)
    private int gpa;
    private String major;
    private String name;

    public Student(int gpa, String major, String name) {
        this.gpa = gpa;
        this.major = major;
        this.name = name;
    }

    @Override // method overrides the same method in the interface
    public int compareTo(Student other) { // other is an instance of Student
        if (this.gpa != other.gpa) { // if gpa is different, sort by gpa
            return other.gpa - this.gpa; // higher gpa first (desc)
            // the result of the return statement decides the order, if the result is positive, this.gpa gets placed before other.gpa in the list, and vice versa
        }

        int majorCompare = this.major.compareTo(other.major); 
        // if gpa is the same, sort by major alphabetically
        if (majorCompare != 0) { // if major is different, sort by major
            return majorCompare;
        }

        return this.name.compareTo(other.name); // if both gpa and major are the same, sort by name
    }

    @Override
    public String toString() { // override toString to format printing
        return name + " - " + major + " - " + gpa;
    }
}
