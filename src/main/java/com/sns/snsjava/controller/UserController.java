package com.sns.snsjava.controller;

import com.sns.snsjava.controller.request.UserJoinRequest;
import com.sns.snsjava.controller.request.UserLoginRequest;
import com.sns.snsjava.controller.response.Response;
import com.sns.snsjava.controller.response.UserJoinResponse;
import com.sns.snsjava.controller.response.UserLoginResponse;
import com.sns.snsjava.model.User;
import com.sns.snsjava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request){
        User user = userService.join(request.getUserName(), request.getPassword());
        return Response.success(UserJoinResponse.fromUser(user));
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        String token = userService.login(request.getUserName(), request.getPassword());
        return Response.success(new UserLoginResponse(token));
    }
}
