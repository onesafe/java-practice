package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by onesafe on 02/09/2019 5:12 PM.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private long orderId;

    private String orderNum;

    private LocalDateTime createTime;
}
