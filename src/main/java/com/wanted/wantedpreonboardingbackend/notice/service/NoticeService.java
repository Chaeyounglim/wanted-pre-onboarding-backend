package com.wanted.wantedpreonboardingbackend.notice.service;

import com.wanted.wantedpreonboardingbackend.notice.dto.NoticeRequestDto;

public interface NoticeService {

  /**
   * 공고 등록 메서드
   * @param requestDto 공고를 등록할 데이터 ()
   */
  void createNotice(NoticeRequestDto requestDto);


  /**
   * 공고 수정 메서드
   * @param requestDto 공고를 수정할 데이터 ()
   */
  void updateNotice(NoticeRequestDto requestDto);


  /**
   * 공고 삭제 메서드
   * @param id 삭제할 공고의 id 값
   */
  void deleteNotice(Long id);



}
