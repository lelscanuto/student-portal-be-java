package com.mist.portal.academic.service.subjects.application.use_cases;

import com.mist.portal.academic.service.subjects.application.dto.SubjectLiteDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectUpdateDTO;
import jakarta.annotation.Nonnull;

public interface SubjectUpdateUseCase {
  SubjectLiteDTO update(@Nonnull Long id, @Nonnull SubjectUpdateDTO subjectCreateDTO);
}
