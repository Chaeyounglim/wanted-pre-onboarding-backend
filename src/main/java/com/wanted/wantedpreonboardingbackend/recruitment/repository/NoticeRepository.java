package com.wanted.wantedpreonboardingbackend.recruitment.repository;

import com.wanted.wantedpreonboardingbackend.recruitment.entity.Notice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {



  List<Notice> findByCompany_NameContaining(String name);
  List<Notice> findByCompany_NationContaining(String nation);
  List<Notice> findByCompany_RegionContaining(String nation);
  List<Notice> findByPositionContaining(String position);
  List<Notice> findByTitleContaining(String title);
  List<Notice> findByContentContaining(String content);
  List<Notice> findBySkillContaining(String skill);

  List<Notice> findNByCompany_Id(Long id);


}
