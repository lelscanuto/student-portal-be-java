package com.mist.portal.academic.service.subjects.domain.factories;

import com.mist.portal.academic.service.subjects.application.dto.SubjectCreateDTO;
import com.mist.portal.academic.service.subjects.domain.entities.Subject;

public interface SubjectFactory {
  Subject create(SubjectCreateDTO subjectCreateDTO);
}
