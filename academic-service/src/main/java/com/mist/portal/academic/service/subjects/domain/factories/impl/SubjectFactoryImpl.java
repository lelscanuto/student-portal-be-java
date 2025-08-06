package com.mist.portal.academic.service.subjects.domain.factories.impl;

import com.mist.portal.academic.service.subjects.application.dto.SubjectCreateDTO;
import com.mist.portal.academic.service.subjects.domain.entities.Subject;
import com.mist.portal.academic.service.subjects.domain.factories.SubjectFactory;
import org.springframework.stereotype.Service;

@Service
public class SubjectFactoryImpl implements SubjectFactory {
  @Override
  public Subject create(SubjectCreateDTO subjectCreateDTO) {
    return Subject.builder()
        .code(subjectCreateDTO.code())
        .title(subjectCreateDTO.title())
        .description(subjectCreateDTO.description())
        .units(subjectCreateDTO.units())
        .build();
  }
}
