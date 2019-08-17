package designpatten.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpMemento {
    private String name;
    private int age;
    private double salary;

    public EmpMemento(Emp e) {
        this.name = e.getName();
        this.age = e.getAge();
        this.salary = e.getSalary();
    }
}
