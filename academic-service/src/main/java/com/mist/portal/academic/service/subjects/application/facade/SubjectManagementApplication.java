package com.mist.portal.academic.service.subjects.application.facade;

import com.mist.portal.academic.service.subjects.application.dto.SubjectCreateDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectLiteDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectUpdateDTO;
import jakarta.annotation.Nonnull;

public interface SubjectManagementApplication {

  SubjectLiteDTO add(@Nonnull SubjectCreateDTO subjectCreateDTO);

  SubjectLiteDTO remove(@Nonnull Long id);

  SubjectLiteDTO update(@Nonnull Long id, @Nonnull SubjectUpdateDTO subjectCreateDTO);

  SubjectLiteDTO restore(@Nonnull Long id);
}
