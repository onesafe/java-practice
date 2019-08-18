package annotation;

import lombok.Data;

@WypTable("tb_student")
@Data
public class Student {

    @WypField(columnName = "id", type = "int", length = 10)
    private int id;

    @WypField(columnName = "sname", type = "varchar", length = 10)
    private String name;

    @WypField(columnName = "age", type = "int", length = 3)
    private int age;
}
