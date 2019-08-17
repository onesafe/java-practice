package designpatten.creator.prototype.example2;

public class Client {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("刘老师");

        Student stu1 = new Student();
        stu1.setName("学生1");
        stu1.setTeacher(teacher);

        Student stu2 = stu1.clone();
        stu2.setName("学生2");
        stu2.getTeacher().setName("汪老师");

        System.out.println(stu1);
        System.out.println(stu2);
    }
}
