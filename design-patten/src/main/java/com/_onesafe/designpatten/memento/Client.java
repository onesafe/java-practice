package com._onesafe.designpatten.memento;

public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();

        Emp emp = new Emp("onesafe", 18, 900);
        System.out.println("第一次打印对象：" + emp.getName() + "---" + emp.getAge() + "---" + emp.getSalary());

        taker.setMemento(emp.memento()); // 备份一次

        emp.setAge(40);
        emp.setName("www");
        emp.setSalary(1000);
        System.out.println("第二次打印对象：" + emp.getName() + "---" + emp.getAge() + "---" + emp.getSalary());


        emp.recovery(taker.getMemento()); // 恢复到备忘录对象保存的状态
        System.out.println("第三次打印对象：" + emp.getName() + "---" + emp.getAge() + "---" + emp.getSalary());

    }
}
