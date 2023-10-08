package com.livegoods.commons.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginLog {
    // 日志id
    private String id;

    // 登录人
    private String username;

    // 登录方式
    private String type;

    // 登录时间
    private Date logintime;

    // 登录是否成功
    private Boolean isSuccess;

    // 日志消息
    private String message;
}
