package com.wanted.wantedpreonboardingbackend.recruitment.dto;

import com.wanted.wantedpreonboardingbackend.recruitment.entity.Notice;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeResponseDto {

  /**
   * Example)
   * # 데이터 예시이며, 필드명은 임의로 설정가능합니다.
   * {
   *   "회사_id":회사_id,
   *   "채용포지션":"백엔드 주니어 개발자",
   *   "채용보상금":1000000,
   *   "채용내용":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
   *   "사용기술":"Python"
   * }
   */

  private Long id;
  private String name;
  private String nation;
  private String region;
  private String position;
  private Long reward;
  private String skill;


  public NoticeResponseDto(Notice notice) {
    this.id = notice.getId();
    this.name = notice.getCompany().getName();
    this.nation = notice.getCompany().getNation();
    this.region = notice.getCompany().getRegion();
    this.position = notice.getPosition();
    this.reward = notice.getReward();
    this.skill = notice.getSkill();
  }

}
