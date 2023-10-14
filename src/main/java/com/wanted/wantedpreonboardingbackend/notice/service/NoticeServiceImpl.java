package com.wanted.wantedpreonboardingbackend.notice.service;

import com.wanted.wantedpreonboardingbackend.notice.dto.ApplyRequestDto;
import com.wanted.wantedpreonboardingbackend.notice.dto.NoticeRequestDto;
import com.wanted.wantedpreonboardingbackend.notice.dto.NoticeResponseDto;
import com.wanted.wantedpreonboardingbackend.notice.entity.Company;
import com.wanted.wantedpreonboardingbackend.notice.entity.Notice;
import com.wanted.wantedpreonboardingbackend.notice.repository.CompanyRepository;
import com.wanted.wantedpreonboardingbackend.notice.repository.NoticeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

  private final NoticeRepository noticeRepository;
  private final CompanyRepository companyRepository;

  @Override
  public void createNotice(NoticeRequestDto requestDto) {
    Company company = companyRepository.findById(requestDto.getCompanyId()).get();
    Notice notice = new Notice(requestDto, company);
    noticeRepository.save(notice);
  }

  @Override
  @Transactional
  public void updateNotice(NoticeRequestDto requestDto) {
    Notice notice = noticeRepository.findById(requestDto.getNoticeId()).get();
    notice.update(requestDto);
  }

  @Override
  public void deleteNotice(Long id) {
    Optional<Notice> existNotice = noticeRepository.findById(id);

    if(existNotice.isPresent()) {
      noticeRepository.delete(existNotice.get());
      log.info(id + "의 공고 삭제 완료");
    }else {
      log.error(id + "에 해당하는 공고가 없습니다.");
    }
  }

  public List<NoticeResponseDto> getNoticeList() {
    List<Notice> noticeList = noticeRepository.findAll();
    List<NoticeResponseDto> result = new ArrayList<>();

    if(noticeList.size()>=1) { // 공고 정보가 있을 경우
      for (Notice notice : noticeList) {
        NoticeResponseDto noticeResponseDto = new NoticeResponseDto(notice);
        result.add(noticeResponseDto);
      }
    }else { // 공고가 한개도 없을 경우
      return null;
    }
    return result;
  }


  public List<NoticeResponseDto> searchNotice(String search) {

    return null;
  }

  public void applyNotice(ApplyRequestDto requestDto) {
  }
}
