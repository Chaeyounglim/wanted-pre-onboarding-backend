package com.wanted.wantedpreonboardingbackend.notice.repository;

import com.wanted.wantedpreonboardingbackend.notice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
