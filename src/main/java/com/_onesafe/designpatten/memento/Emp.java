package com._onesafe.designpatten.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 源发器类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    private String name;
    private int age;
    private double salary;


    // 进行备忘操作，并返回备忘录对象
    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    // 进行数据恢复，恢复成制定备忘录对象的值
    public void recovery(EmpMemento mmt) {
        this.name = mmt.getName();
        this.age = mmt.getAge();
        this.salary = mmt.getSalary();
    }

}
