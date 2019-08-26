package designpatten.actor.chainOfResp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装请假的基本信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequest {
    private String empName;
    private int leaveDays;
    private String reason;
}
