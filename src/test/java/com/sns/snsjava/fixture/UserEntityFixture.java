package com.sns.snsjava.fixture;

import com.sns.snsjava.model.UserRole;
import com.sns.snsjava.model.entity.UserEntity;

import java.sql.Timestamp;
import java.time.Instant;

public class UserEntityFixture {

    public static UserEntity get(String userName, String password){
        UserEntity result = new UserEntity();
        result.setId(1);
        result.setUserName(userName);
        result.setPassword(password);
        return result;
    }

}
