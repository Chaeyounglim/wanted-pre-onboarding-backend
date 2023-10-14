package com.wanted.wantedpreonboardingbackend.recruitment.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeRequestDto {

  private Long companyId; // 회사 id
  private Long noticeId; // 공고 id
  private String name;
  private String nation;
  private String region;
  private String position;
  private Long reward;
  private String title;
  private String content;
  private String skill;
  private Date exfiredAt;

}
