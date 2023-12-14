package com.sns.snsjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlarmArgs {

    //    알람을 발생시킨 사람
    private Integer fromUserId;
    //    알람이 발생된 주체의 아이디
    private Integer targetId;
}