package designpatten.creator.prototype.example1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sheep implements Cloneable {

    private String sname;
    private Date birthday;

    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();

        // 添加下面代码实现深拷贝
        Sheep s = (Sheep) obj;
        s.birthday = (Date) this.birthday.clone();
        return obj;
    }
}
