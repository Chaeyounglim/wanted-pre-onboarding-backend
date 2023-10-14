package com.wanted.wantedpreonboardingbackend.recruitment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.wanted.wantedpreonboardingbackend.recruitment.dto.NoticeRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;

// lombok
@Getter
@NoArgsConstructor

// jpa
@Entity
public class Notice {

  /**
   * 컬럼 - 연관관계 컬럼을 제외한 컬럼을 정의합니다.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "company_id", nullable = false)
  private Company company; // 회사

  private String title; // 채용 공고 제목

  private String content; // 채용 공고 내용

  private String position; // 채용 포지션

  private Long reward; // 채용 보상금

  private String skill; // 사용 기술

  @JsonFormat(shape = Shape.STRING,pattern = "yyyy-mm-dd")
  private Date exfiredAt; // 공고 마감일자


  /**
   * 생성자 - 약속된 형태로만 생성가능하도록 합니다.
   */
  public Notice(NoticeRequestDto requestDto, Company company) {
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
    this.position = requestDto.getPosition();
    this.reward = requestDto.getReward();
    this.skill = requestDto.getSkill();
    this.exfiredAt = requestDto.getExfiredAt();
    this.company = company;
  }


  /**
   * 연관관계 - Foreign Key 값을 따로 컬럼으로 정의하지 않고 연관 관계로 정의합니다.
   */


  /**
   * 연관관계 편의 메소드 - 반대쪽에는 연관관계 편의 메소드가 없도록 주의합니다.
   */


  /**
   * 서비스 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
   */
  public void update(NoticeRequestDto requestDto) {
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
    this.position = requestDto.getPosition();
    this.reward = requestDto.getReward();
    this.skill = requestDto.getSkill();
  }





}
