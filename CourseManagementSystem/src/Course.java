import java.util.ArrayList;

public class Course {

    private final String name;
    private final Teacher teacher;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        this.teacher.addCourse(this);
    }

    public void removeCourse() {
        for (Student student : students) {
            student.removeCourse(this);
        }
        this.teacher.removeCourse(this);
    }

    public String getName() {
        return this.name;
    }

    protected Teacher getTeacher() {
        return this.teacher;
    }

    protected ArrayList<Student> getStudents() {
        return this.students;
    }

    protected void addStudent(Student student) {
        students.add(student);
    }
}
