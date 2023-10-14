package com.wanted.wantedpreonboardingbackend.recruitment.dto;

import com.wanted.wantedpreonboardingbackend.recruitment.entity.Notice;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDetailResponseDto extends NoticeResponseDto {

  private String content;
  private List<Long> noticeList; // 회사가 올린 다른 채용 공고 id 리스트

  public NoticeDetailResponseDto(Notice notice, List<Long> list) {
    super(notice);
    this.content = notice.getContent();
    this.noticeList = list;
  }
}
