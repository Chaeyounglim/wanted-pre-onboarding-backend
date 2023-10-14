package com.wanted.wantedpreonboardingbackend.notice.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeSearchDto {
  // 회사명, 국가, 지역, 채용 포지션, 보상금, 기술

  private String companyName;
  private String nation;
  private String region;
  private String position;
  private String title;
  private String content;
  private String skill;

}
