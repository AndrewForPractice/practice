public class Student {
    private String name;
    private int age;
    private int id;
    private String academicCourse;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", academicCourse='" + academicCourse + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getacademicCourse() {
        return academicCourse;
    }

    public void setacademicCourse(String academicCourse) {
        this.academicCourse = academicCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
