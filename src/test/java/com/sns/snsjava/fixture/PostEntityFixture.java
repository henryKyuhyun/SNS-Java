package com.sns.snsjava.fixture;

import com.sns.snsjava.model.entity.PostEntity;
import com.sns.snsjava.model.entity.UserEntity;

public class PostEntityFixture {

    public static PostEntity get(String userName, Integer postId){
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setUserName(userName);

        PostEntity result = new PostEntity();
        result.setUser(user);
        result.setId(postId);
        return result;

    }
}
