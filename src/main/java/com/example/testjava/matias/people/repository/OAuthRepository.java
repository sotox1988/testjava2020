package com.example.testjava.matias.people.repository;

import com.example.testjava.matias.people.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuthRepository extends JpaRepository<UserEntity,Integer> {

    UserEntity findByUsername(String username);
}
