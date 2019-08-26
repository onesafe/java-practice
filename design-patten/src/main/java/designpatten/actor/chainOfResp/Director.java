package designpatten.actor.chainOfResp;

public class Director extends Leader {

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays() < 3) {
            System.out.println("员工： " + request.getEmpName() + "请假天数： " + request.getLeaveDays() + "请假原因：" + request.getReason());
            System.out.println("主管： " + this.name + "，审批通过");
        } else {
            if(this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
