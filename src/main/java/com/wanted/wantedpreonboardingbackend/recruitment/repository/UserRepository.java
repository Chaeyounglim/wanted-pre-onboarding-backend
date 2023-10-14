package com.wanted.wantedpreonboardingbackend.recruitment.repository;

import com.wanted.wantedpreonboardingbackend.recruitment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
