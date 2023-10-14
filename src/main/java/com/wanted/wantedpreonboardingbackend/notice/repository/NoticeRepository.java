package com.wanted.wantedpreonboardingbackend.notice.repository;

import com.wanted.wantedpreonboardingbackend.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
