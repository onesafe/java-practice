package designpatten.actor.chainOfResp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        super();
        this.name = name;
    }

    /**
     * 处理请求的核心业务方法
     * @param request 请求参数
     */
    public abstract void handleRequest(LeaveRequest request);
}
