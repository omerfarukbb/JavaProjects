import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> studentArrayList = new ArrayList<>();
    static ArrayList<Teacher> teacherArrayList = new ArrayList<>();
    static ArrayList<Course> courseArrayList = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choice;
        handleMenuOptions();
        while (true) {
            System.out.print("Enter: ");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                handleStudentMenu(scanner);
                handleMenuOptions();
            } else if (choice.equals("2")) {
                handleCourseMenu(scanner);
                handleMenuOptions();
            } else if (choice.equals("3")) {
                handleTeacherMenu(scanner);
                handleMenuOptions();
            } else if (choice.equals("q")) {
                System.out.println("Quitting...");
                break;
            } else {
                System.out.println("Wrong selection, try again!");
            }
        }
    }

    private static void handleMenuOptions() {
        System.out.println("------- MAIN MENU -------");
        System.out.println("1 for Student operations");
        System.out.println("2 for Course operations");
        System.out.println("3 for Teacher operations");
        System.out.println("q for Quit");
    }

    private static void handleStudentMenu(Scanner scanner) {
        String choice;
        System.out.println("------- Student -------");
        System.out.println("1 - New student");
        System.out.println("2 - Select a student");
        System.out.println("3 - Return to the menu");

        while (true) {
            System.out.print("Enter: ");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter the name: ");
                String name = scanner.nextLine();
                System.out.print("Enter the surname: ");
                String surname = scanner.nextLine();
                Student student = new Student(name, surname);
                studentArrayList.add(student);
                System.out.println("Student ID: " + student.getPersonId());
                break;
            } else if (choice.equals("2")) {
                System.out.print("Enter the student ID: ");
                String id = scanner.nextLine();
                Student student = null;
                for (Student studentTemp: studentArrayList) {
                    if (studentTemp.getPersonId().equals(id)) {
                        student = studentTemp;
                        break;
                    }
                }
                if (student == null) {
                    System.out.println("Not found such a student! Returning to the menu...");
                    break;
                }
                handleStudentOperations(student, scanner);
                break;
            } else if (choice.equals("3")) {
                System.out.println("Returning...");
                break;
            } else {
                System.out.println("Wrong selection, try again!");
            }
        }

    }

    private static void handleStudentOperations(Student student, Scanner scanner) {
        System.out.printf("----- %s -----\n", student.getFullName());
        System.out.println("1 - Add course");
        System.out.println("2 - Remove course");
        System.out.println("3 - View the taken courses");
        System.out.println("4 - Return to the menu");

        String choice;
        while (true) {
            System.out.print("Enter: ");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter the course name: ");
                choice = scanner.nextLine();
                Course course = null;
                for (Course courseTemp: courseArrayList) {
                    if (courseTemp.getName().equals(choice)) {
                        course = courseTemp;
                        break;
                    }
                }
                if (course == null) {
                    System.out.println("No such a course! Returning to the menu...");
                } else {
                    course.addStudent(student);
                    student.addCourse(course);
                    System.out.printf("The course %s is added successfully.\n", choice);
                }
                break;
            } else if (choice.equals("2")) {
                System.out.print("Enter the course name: ");
                choice = scanner.nextLine();
                Course course = null;
                for (Course courseTemp: student.getCoursesTaken()) {
                    if (courseTemp.getName().equals(choice)) {
                        course = courseTemp;
                        break;
                    }
                }
                if (course == null) {
                    System.out.println("No such a course! Returning to the menu...");
                } else if (student.removeCourse(course)) {
                    System.out.printf("The course %s removed successfully.\n", course.getName());
                } else {
                    System.out.println("The course %s is not taken by student.");
                }
                break;
            } else if (choice.equals("3")) {
                System.out.println("Courses taken are: ");
                for (Course course: student.getCoursesTaken()) {
                    System.out.println("- " + course.getName());
                }
                break;
            } else if (choice.equals("4")) {
                System.out.println("Returning...");
                break;
            } else {
                System.out.println("Wrong selection, try again!");
            }
        }
    }


    private static void handleTeacherMenu(Scanner scanner) {
        String choice;
        System.out.println("------- Teacher -------");
        System.out.println("1 - New teacher");
        System.out.println("2 - Select a teacher");
        System.out.println("3 - Return to the menu");

        while (true) {
            System.out.print("Enter: ");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter the name: ");
                String name = scanner.nextLine();
                System.out.print("Enter the surname: ");
                String surname = scanner.nextLine();
                Teacher teacher = new Teacher(name, surname);
                teacherArrayList.add(teacher);
                System.out.println("Teacher ID: " + teacher.getPersonId());
                break;
            } else if (choice.equals("2")) {
                System.out.print("Enter the teacher ID: ");
                String id = scanner.nextLine();
                Teacher teacher = null;
                for (Teacher teacherTemp: teacherArrayList) {
                    if (teacherTemp.getPersonId().equals(id)) {
                        teacher = teacherTemp;
                        break;
                    }
                }
                if (teacher == null) {
                    System.out.println("Not found such a teacher! Returning to the menu...");
                    break;
                }
                handleTeacherOperations(teacher, scanner);
                break;
            } else if (choice.equals("3")) {
                System.out.println("Returning...");
                break;
            } else {
                System.out.println("Wrong selection, try again!");
            }
        }
    }

    private static void handleTeacherOperations(Teacher teacher, Scanner scanner) {
        System.out.printf("----- %s -----\n", teacher.getFullName());
        System.out.println("1 - Add course");
        System.out.println("2 - Remove course");
        System.out.println("3 - View the given courses");
        System.out.println("4 - Return to the menu");

        String choice;
        while (true) {
            System.out.print("Enter: ");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter the course name: ");
                String courseName = scanner.nextLine();
                Course course = new Course(courseName, teacher);
                courseArrayList.add(course);
                System.out.printf("The course %s created successfully.\n", courseName);
                break;
            } else if (choice.equals("2")) {
                System.out.print("Enter the course name: ");
                String courseName = scanner.nextLine();

                Course course = null;
                for (Course courseTemp: teacher.getCoursesGiven()) {
                    if (courseTemp.getName().equals(courseName)) {
                        course = courseTemp;
                        break;
                    }
                }
                if (course == null) {
                    System.out.println("No such a course! Returning to the menu...");
                } else {
                    courseArrayList.remove(course);
                    course.removeCourse();
                    System.out.printf("The course %s removed successfully.\n", courseName);
                }
                break;
            } else if (choice.equals("3")) {
                System.out.println("Courses given are: ");
                for (Course course: teacher.getCoursesGiven()) {
                    System.out.println("- " + course.getName());
                }
                break;
            } else if (choice.equals("4")) {
                System.out.println("Returning...");
                break;
            } else {
                System.out.println("Wrong selection, try again!");
            }
        }
    }

    private static void handleCourseMenu(Scanner scanner) {
        String choice;
        System.out.println("------- Course -------");
        System.out.println("1 - Select a course");
        System.out.println("2 - View all courses");
        System.out.println("3 - Return to the menu");

        while (true) {
            System.out.print("Enter: ");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter the course name: ");
                String courseName = scanner.nextLine();

                Course course = null;
                for (Course courseTemp: courseArrayList) {
                    if (courseTemp.getName().equals(courseName)) {
                        course = courseTemp;
                        break;
                    }
                }

                if (course == null) {
                    System.out.println("No such a course!");
                    break;
                }
                handleCourseOperations(course, scanner);
                break;
            } else if (choice.equals("2")) {
                System.out.println("The courses are: ");
                for (Course course: courseArrayList) {
                    System.out.println("- " + course.getName());
                }
                break;
            } else if (choice.equals("3")) {
                System.out.println("Returning...");
                break;
            } else {
                System.out.println("Wrong selection, try again!");
            }
        }
    }

    private static void handleCourseOperations(Course course, Scanner scanner) {
        System.out.printf("----- %s -----\n", course.getName());
        System.out.println("1 - View the teacher");
        System.out.println("2 - View all students");
        System.out.println("3 - Return to the menu");

        String choice;
        while (true) {
            System.out.print("Enter: ");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.printf("The teacher is %s.\n", course.getTeacher().getFullName());
                break;
            } else if (choice.equals("2")) {
                System.out.println("The students are: ");
                for (Student student: course.getStudents()) {
                    System.out.println("- " + student.getFullName());
                }
                break;
            } else if (choice.equals("3")) {
                System.out.println("Returning...");
                break;
            } else {
                System.out.println("Wrong selection, try again!");
            }
        }
    }


}