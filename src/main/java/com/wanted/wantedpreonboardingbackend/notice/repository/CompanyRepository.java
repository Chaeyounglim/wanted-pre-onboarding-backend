package com.wanted.wantedpreonboardingbackend.notice.repository;

import com.wanted.wantedpreonboardingbackend.notice.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
