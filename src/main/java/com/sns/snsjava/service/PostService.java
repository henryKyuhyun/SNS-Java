package com.sns.snsjava.service;

import com.sns.snsjava.exception.ErrorCode;
import com.sns.snsjava.exception.SnsApplicationException;
import com.sns.snsjava.model.Post;
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
    public Post modify(String title, String body, String userName, Integer postId) {
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new SnsApplicationException(ErrorCode.USER_NOT_FOUNDED, String.format("%s not founded", userName)));

//        post exist
        PostEntity postEntity = postEntityRepository.findById(postId).orElseThrow(() ->
                new SnsApplicationException(ErrorCode.POST_NOT_FOUND, String.format("%s not founded", postId)));
//        post permission
        if (postEntity.getUser() != userEntity) {
            throw new SnsApplicationException(ErrorCode.INVALID_PERMISSION, String.format("%s has no permission with %s", userName,postId));
        }

        postEntity.setTitle(title);
        postEntity.setBody(body);

        return Post.fromEntity(postEntityRepository.save(postEntity));

    }
}
