package com.sns.snsjava.fixture;

import com.sns.snsjava.model.UserRole;
import com.sns.snsjava.model.entity.UserEntity;

import java.sql.Timestamp;
import java.time.Instant;

public class UserEntityFixture {

    public static UserEntity get(String userName, String password,Integer userId){
        UserEntity result = new UserEntity();
        result.setId(userId);
        result.setUserName(userName);
        result.setPassword(password);
        return result;
    }

}
