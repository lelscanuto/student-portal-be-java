package com.mist.portal.academic.service.subjects.domain.repositories;

import com.mist.portal.academic.service.subjects.domain.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
  boolean existsByCode(String code);
}
