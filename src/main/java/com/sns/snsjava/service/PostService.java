package com.sns.snsjava.service;

import com.sns.snsjava.exception.ErrorCode;
import com.sns.snsjava.exception.SnsApplicationException;
import com.sns.snsjava.model.entity.PostEntity;
import com.sns.snsjava.model.entity.UserEntity;
import com.sns.snsjava.repository.PostEntityRepository;
import com.sns.snsjava.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostEntityRepository postEntityRepository;
    private final UserEntityRepository userEntityRepository;

    @Transactional
    public void create(String title, String body, String userName) {
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new SnsApplicationException(ErrorCode.USER_NOT_FOUNDED, String.format("%s not founded", userName)));
        postEntityRepository.save(PostEntity.of(title,body,userEntity));

    }

    @Transactional
    public void modify(String title, String body, String userName, Integer postId) {
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new SnsApplicationException(ErrorCode.USER_NOT_FOUNDED, String.format("%s not founded", userName)));

//        post exist

//        post permission

    }
}
