import java.util.ArrayList;

public class Teacher extends Person {

    private final ArrayList<Course> coursesGiven = new ArrayList<>();

    public Teacher(String name, String surname) {
        super(name, surname);
    }

    public void addCourse(Course course) {
        coursesGiven.add(course);
    }

    public void removeCourse(Course course) {
        coursesGiven.remove(course);
    }

    protected ArrayList<Course> getCoursesGiven() {
        return this.coursesGiven;
    }
}
