package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by onesafe on 02/09/2019 2:28 PM.
 */
@Data
public class User implements Serializable {

    private String username;

    private String password;

    private Date createTime;
}
