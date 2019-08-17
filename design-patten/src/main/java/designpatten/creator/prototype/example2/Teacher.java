package designpatten.creator.prototype.example2;

import lombok.Data;

@Data
public class Teacher implements Cloneable {

    private String name;

    public Teacher clone() {
        Teacher teacher = null;
        try {
            teacher = (Teacher) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}
