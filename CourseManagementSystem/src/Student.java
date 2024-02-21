import java.util.ArrayList;

public class Student extends Person {

    private final ArrayList<Course> coursesTaken = new ArrayList<>();

    public Student(String name, String surname) {
        super(name, surname);
    }

    public void addCourse(Course course) {
        coursesTaken.add(course);
    }

    public boolean removeCourse(Course course) {
        return coursesTaken.remove(course);
    }

    protected ArrayList<Course> getCoursesTaken() {
        return this.coursesTaken;
    }
}
