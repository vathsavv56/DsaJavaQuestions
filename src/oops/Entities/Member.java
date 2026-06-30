package oops.Entities;

//### Member (general role)
//- Has: id, name, join date
//- Every member type must define its own borrow limit and its own fine-per-day-late rate
//- Common behavior (checking if they're under their limit) should live in one place, not repeated per type



public class Member {
    private int id;
    private String name;
    private DateType joinDate;
    private  final int BORROW_LIMIT = 6;
    private final  int FINE_PER_DAY = 5;


    public Member(int id, String name, DateType joinDate) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateType getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(DateType joinDate) {
        this.joinDate = joinDate;
    }

}
