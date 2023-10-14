package com.wanted.wantedpreonboardingbackend.recruitment.repository;

import com.wanted.wantedpreonboardingbackend.recruitment.entity.Apply;
import com.wanted.wantedpreonboardingbackend.recruitment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

  Boolean existsByUser(User user);
}
