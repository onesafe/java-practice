package designpatten.creator.prototype.example2;

import lombok.Data;

@Data
public class Student implements Cloneable {

    private String name;
    private Teacher teacher;

    public Student clone() {
        Student student = null;
        try {
            student = (Student) super.clone();

            // 深拷贝
            Teacher teacher = this.teacher.clone();
            student.setTeacher(teacher);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;
    }
}
