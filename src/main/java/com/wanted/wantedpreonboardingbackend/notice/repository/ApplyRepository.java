package com.wanted.wantedpreonboardingbackend.notice.repository;

import com.wanted.wantedpreonboardingbackend.notice.entity.Apply;
import com.wanted.wantedpreonboardingbackend.notice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

  Boolean existsByUser(User user);
}
