package com.sns.snsjava.repository;

import com.sns.snsjava.model.Post;
import com.sns.snsjava.model.entity.LikeEntity;
import com.sns.snsjava.model.entity.PostEntity;
import com.sns.snsjava.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeEntityRepository extends JpaRepository<LikeEntity, Integer > {

    Optional<LikeEntity> findByUserAndPost(UserEntity user, PostEntity post);

}
