package com.wanted.wantedpreonboardingbackend.notice.service;

import com.wanted.wantedpreonboardingbackend.notice.dto.ApplyRequestDto;
import com.wanted.wantedpreonboardingbackend.notice.dto.NoticeDetailResponseDto;
import com.wanted.wantedpreonboardingbackend.notice.dto.NoticeRequestDto;
import com.wanted.wantedpreonboardingbackend.notice.dto.NoticeResponseDto;
import com.wanted.wantedpreonboardingbackend.notice.dto.NoticeSearchDto;
import java.util.List;

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

  /**
   * 공고 목록 전체 조회 메서드
   * @return 공고 전체 목록
   */
  List<NoticeResponseDto> getNoticeList();

  /**
   * 검색 조회 메서드
   * @param requestDto 검색 필드에 따른 조건값
   * @return 검색 조건에 해당되는 공고 목록 반환
   */
  List<NoticeResponseDto> searchNotice(NoticeSearchDto requestDto);


  /**
   * 공고 상세 조회 메서드
   * @param noticeId 상세 조회할 메서드 id 값
   * @return 공고 내용과 해당 공고를 올린 회사의 다른 공고 id 목록 반환
   */
  NoticeDetailResponseDto getNoticeDetail(Long noticeId);


  /**
   * 공고 지원하는 메서드
   * @param requestDto 공고와 지원자 id값
   */
  void applyNotice(ApplyRequestDto requestDto);


}
