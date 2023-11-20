package com.sns.snsjava.controller.response;

import com.sns.snsjava.model.User;
import com.sns.snsjava.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class UserJoinResponse {

    private Integer id;
    private String userName;
//    Password 는 굳이 반환할필요없으니까 안넣음
    private UserRole role;

    public static UserJoinResponse fromUser(User user) {
        return new UserJoinResponse(
                user.getId(),
                user.getUserName(),
                user.getUserRole()
        );
    }


}
