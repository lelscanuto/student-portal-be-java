package com.mist.portal.academic.service.subjects.application.use_cases;

import com.mist.portal.academic.service.subjects.application.dto.SubjectCreateDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectLiteDTO;
import jakarta.annotation.Nonnull;

public interface SubjectCreationUseCase {
  SubjectLiteDTO create(@Nonnull SubjectCreateDTO subjectCreateDTO);
}
