package com.wanted.wantedpreonboardingbackend.recruitment.controller;

import com.wanted.wantedpreonboardingbackend.recruitment.dto.ApplyRequestDto;
import com.wanted.wantedpreonboardingbackend.recruitment.dto.NoticeDetailResponseDto;
import com.wanted.wantedpreonboardingbackend.recruitment.dto.NoticeRequestDto;
import com.wanted.wantedpreonboardingbackend.recruitment.dto.NoticeResponseDto;
import com.wanted.wantedpreonboardingbackend.recruitment.dto.NoticeSearchDto;
import com.wanted.wantedpreonboardingbackend.recruitment.service.NoticeServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class NoticeController {

  private final NoticeServiceImpl noticeService;

  /** OK
   * 1번 기능 : 채용 공고를 등록하는 메서드
   * url : http://localhost:8081/api/notice [POST]
   *
   * @param requestDto 채용 공고를 등록할 데이터
   */
  @PostMapping("/notice")
  public void createNotice(@RequestBody NoticeRequestDto requestDto) {
    noticeService.createNotice(requestDto);
  }


  /** OK
   * 2번 기능 : 채용 공고를 수정하는 메서드
   * url : http://localhost:8081/api/notice [PUT]
   *
   * @param requestDto 채용 공고를 수정할 데이터
   */
  @PutMapping("/notice")
  public void updateNotice(@RequestBody NoticeRequestDto requestDto) {
    noticeService.updateNotice(requestDto);
  }


  /** OK
   * 3번 기능 : body로 전달 받은 id 값에 따른 공고 삭제 메서드
   * url : http://localhost:8081/api/notice [DELETE]
   *
   * url이 아닌 body로 전달을 받은 이유는 추후 XSS 공격을 우려하여 보안상의 문제를 염려하여 선택
   *
   * @param requestDto 삭제할 공고 id 값
   */
  @DeleteMapping("/notice")
  public void deleteNotice(@RequestBody NoticeRequestDto requestDto) {
    noticeService.deleteNotice(requestDto.getNoticeId());
  }


  /** OK
   * 4-1번 기능 : 채용 공고 목록 조회 메서드
   * url : http://localhost:8081/api/notice [GET]
   *
   * @return 채용 공고 목록
   */
  @GetMapping("/notice")
  public List<NoticeResponseDto> getNoticeList() {
    return noticeService.getNoticeList();
  }


  /** OK
   * 4-2번 기능 : 채용 공고 검색 메서드
   *
   * @param requestDto 검색하고자 할 키워드
   * @return 검색한 채용 공고 목록
   */
  @GetMapping("/notices/search")
  public List<NoticeResponseDto> searchNotice(@RequestBody NoticeSearchDto requestDto) {
    return noticeService.searchNotice(requestDto);
  }


  /** OK
   * 5번 기능
   * 채용 상세 페이지를 가져오는 메서드
   * 해당 회사가 올린 다른 채용공고도 함께 조회
   */
  @GetMapping("/notice/detail")
  public NoticeDetailResponseDto getNoticeDetail(@RequestBody NoticeRequestDto requestDto) {
    return noticeService.getNoticeDetail(requestDto.getNoticeId());
  }


  /** OK
   * 6번 기능 채용 공고 지원 메서드
   *
   * @param requestDto 채용 공고 id, 사용자 id 값
   */
  @PostMapping("/notice/apply")
  public void applyNotice(@RequestBody ApplyRequestDto requestDto) {
    noticeService.applyNotice(requestDto);
  }

}

