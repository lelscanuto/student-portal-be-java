package com.mist.portal.academic.service.subjects.application.mappers;

import com.mist.portal.academic.service.subjects.application.dto.SubjectLiteDTO;
import com.mist.portal.academic.service.subjects.domain.entities.Subject;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SubjectMapper {

  SubjectLiteDTO toSubjectLiteDTO(Subject existingSubject);
}
