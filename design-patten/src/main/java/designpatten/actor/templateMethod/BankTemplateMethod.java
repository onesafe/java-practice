package designpatten.actor.templateMethod;

public abstract class BankTemplateMethod {

    public void takenumber() {
        System.out.println("取号排队");
    }

    public abstract void transact();  //办理具体的业务

    public void evaluate() {
        System.out.println("反馈评分");
    }


    public final void process() {  // 模板方法
        this.takenumber();
        this.transact();
        this.evaluate();
    }
}
