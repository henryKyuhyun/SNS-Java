package com.sns.snsjava.service;

import com.sns.snsjava.SnsjavaApplication;
import com.sns.snsjava.exception.ErrorCode;
import com.sns.snsjava.exception.SnsApplicationException;
import com.sns.snsjava.fixture.UserEntityFixture;
import com.sns.snsjava.model.entity.UserEntity;
import com.sns.snsjava.repository.UserEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserEntityRepository userEntityRepository;

    @MockBean
    private BCryptPasswordEncoder encoder;

    @Test
    void 회원가입_정상적으로_동작(){

        String userName = "userName";
        String password = "password";

//        Mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.empty());
        when(encoder.encode(password)).thenReturn("encrypt_password");
        when(userEntityRepository.save(any())).thenReturn(UserEntityFixture.get(userName,password,1));

        Assertions.assertDoesNotThrow(()-> userService.join(userName,password));
    }


    @Test
    void 회원가입시_userName으로_회원가입한_유저가_이미_있는경우(){

        String userName = "userName";
        String password = "password";
        UserEntity fixture = UserEntityFixture.get(userName, password,1);

//        Mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(fixture));
        when(encoder.encode(password)).thenReturn("encrypt_password");
        when(userEntityRepository.save(any())).thenReturn(Optional.of(fixture));

        SnsApplicationException e = Assertions.assertThrows(SnsApplicationException.class, ()-> userService.join(userName,password));
        Assertions.assertEquals(ErrorCode.DUPLICATED_USER_NAME, e.getErrorCode());
    }

    @Test
    void 로그인이_정상적으로_동작하는_경우(){
        String userName = "userName";
        String password = "password";

        UserEntity fixture = UserEntityFixture.get(userName, password,1);

//        mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(fixture));
        when(encoder.matches(password,fixture.getPassword())).thenReturn(true);

        Assertions.assertDoesNotThrow(()-> userService.login(userName, password));
    }

    @Test
    void 로그인시_userName으로_회원가입한_유저가_없는_경우(){
        String userName = "userName";
        String password = "password";

//        mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.empty());

        SnsApplicationException e = Assertions.assertThrows(SnsApplicationException.class, ()-> userService.join(userName,password));

        Assertions.assertEquals(ErrorCode.USER_NOT_FOUNDED, e.getErrorCode());
    }

    @Test
    void 로그인시_패스워드가_틀린_경우(){

        String userName = "userName";
        String password = "password";
        String wrongPassword = "wrongPassword";

        UserEntity fixture = UserEntityFixture.get(userName, password,1);

//        mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(fixture));

        SnsApplicationException e = Assertions.assertThrows(SnsApplicationException.class, ()-> userService.join(userName,password));
        Assertions.assertEquals(ErrorCode.INVALID_PASSWORD, e.getErrorCode());

    }
}
