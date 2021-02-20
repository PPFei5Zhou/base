package com.easy.base.repository.jpa;

import com.easy.base.domain.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfoEntity, String> { }
