package com.wanted.wantedpreonboardingbackend.notice.service;

import com.wanted.wantedpreonboardingbackend.notice.dto.ApplyRequestDto;
import com.wanted.wantedpreonboardingbackend.notice.dto.NoticeDetailResponseDto;
import com.wanted.wantedpreonboardingbackend.notice.dto.NoticeRequestDto;
import com.wanted.wantedpreonboardingbackend.notice.dto.NoticeResponseDto;
import com.wanted.wantedpreonboardingbackend.notice.dto.NoticeSearchDto;
import com.wanted.wantedpreonboardingbackend.notice.entity.Apply;
import com.wanted.wantedpreonboardingbackend.notice.entity.Company;
import com.wanted.wantedpreonboardingbackend.notice.entity.Notice;
import com.wanted.wantedpreonboardingbackend.notice.entity.User;
import com.wanted.wantedpreonboardingbackend.notice.repository.ApplyRepository;
import com.wanted.wantedpreonboardingbackend.notice.repository.CompanyRepository;
import com.wanted.wantedpreonboardingbackend.notice.repository.NoticeRepository;
import com.wanted.wantedpreonboardingbackend.notice.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
  private final UserRepository userRepository;
  private final ApplyRepository applyRepository;

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

  @Override
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

  @Override
  public List<NoticeResponseDto> searchNotice(NoticeSearchDto requestDto) {
    ArrayList<String> searchKey = new ArrayList<>();
    List<Notice> noticeList = new ArrayList<>();
    List<NoticeResponseDto> result = new ArrayList<>();

    searchKey.add(requestDto.getCompanyName());
    searchKey.add(requestDto.getNation());
    searchKey.add(requestDto.getRegion());
    searchKey.add(requestDto.getPosition());
    searchKey.add(requestDto.getTitle());
    searchKey.add(requestDto.getContent());
    searchKey.add(requestDto.getSkill());

    // 검색 필드에 따른 검색 후의 공고 목록 추출
    for (String search : searchKey) {
      if(search != null) {
        noticeList = searchNoticeList(searchKey, search);
      }
    }

    for (Notice notice : noticeList) {
      NoticeResponseDto responseDto = new NoticeResponseDto(notice);
      result.add(responseDto);
    }

    return result;
  }

  @Override
  public NoticeDetailResponseDto getNoticeDetail(Long noticeId) {
    Notice notice = noticeRepository.findById(noticeId).get();
    Long companyId = notice.getCompany().getId();

    List<Long> idList = noticeRepository.findNByCompany_Id(companyId).stream()
        .map(Notice::getId)
        .collect(Collectors.toList());

    return new NoticeDetailResponseDto(notice,idList);
  }

  @Override
  public void applyNotice(ApplyRequestDto requestDto) {
    User user = userRepository.findById(requestDto.getUserId()).get();
    Notice notice = noticeRepository.findById(requestDto.getNoticeId()).get();

    if(applyRepository.existsByUser(user)) { // 중복 지원이 아닐 경우
      Apply apply = new Apply(notice, user);
      applyRepository.save(apply);
    }

  }


  private List<Notice> searchNoticeList(ArrayList<String> searchKey, String search) {
    return switch (searchKey.indexOf(search)) {
      case 0 -> noticeRepository.findByCompany_NameContaining(search);
      case 1 -> noticeRepository.findByCompany_NationContaining(search);
      case 2 -> noticeRepository.findByCompany_RegionContaining(search);
      case 3 -> noticeRepository.findByPositionContaining(search);
      case 4 -> noticeRepository.findByTitleContaining(search);
      case 5 -> noticeRepository.findByContentContaining(search);
      case 6 -> noticeRepository.findBySkillContaining(search);
      default -> new ArrayList<>();
    };
  }

}
