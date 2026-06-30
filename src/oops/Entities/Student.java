package oops.Entities;

//
//### Student (a kind of Member)
//- Borrow limit: 3
//        - Fine: ₹2/day late
//
public class Student extends Member {


    public Student(int id, String name, DateType joinDate) {
        super(id, name, joinDate);
    }
}
