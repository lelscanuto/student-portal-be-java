package com.mist.portal.academic.service.subjects.domain.services;

import com.mist.portal.academic.service.subjects.application.dto.SubjectUpdateDTO;
import com.mist.portal.academic.service.subjects.domain.entities.Subject;
import jakarta.annotation.Nonnull;

public interface SubjectDomainService {

  void updateSubject(@Nonnull Subject existingSubject, SubjectUpdateDTO subjectUpdateDTO);

  void restoreSubject(@Nonnull Subject existingSubject);

  void removeSubject(@Nonnull Subject existingSubject);
}
