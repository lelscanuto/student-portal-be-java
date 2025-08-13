package com.mist.portal.academic.service.subjects.application.use_cases.impl;

import static com.school.portal.common.utils.AssertUtil.isFalse;

import com.mist.portal.academic.service.subjects.application.dto.SubjectCreateDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectLiteDTO;
import com.mist.portal.academic.service.subjects.application.mappers.SubjectMapper;
import com.mist.portal.academic.service.subjects.application.use_cases.SubjectCreationUseCase;
import com.mist.portal.academic.service.subjects.domain.exceptions.SubjectAlreadyExistsException;
import com.mist.portal.academic.service.subjects.domain.factories.SubjectFactory;
import com.mist.portal.academic.service.subjects.domain.repositories.SubjectRepository;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the SubjectCreationUseCase interface, responsible for creating new subjects.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SubjectCreationUseCaseImpl implements SubjectCreationUseCase {

  private final SubjectFactory subjectFactory;
  private final SubjectRepository subjectRepository;
  private final SubjectMapper subjectMapper;

  public SubjectCreationUseCaseImpl(
      SubjectFactory subjectFactory,
      SubjectRepository subjectRepository,
      SubjectMapper subjectMapper) {
    this.subjectFactory = subjectFactory;
    this.subjectRepository = subjectRepository;
    this.subjectMapper = subjectMapper;
  }

  /**
   * Creates a new subject based on the provided SubjectCreateDTO.
   *
   * @param subjectCreateDTO the DTO containing the details of the subject to be created
   * @return a SubjectLiteDTO representing the created subject
   * @throws SubjectAlreadyExistsException if a subject with the same code already exists
   */
  @Override
  public SubjectLiteDTO create(@Nonnull SubjectCreateDTO subjectCreateDTO) {

    // Validate that the subject code is not already in use
    isFalse(subjectRepository.existsByCode(subjectCreateDTO.code()))
        .elseThrow(() -> SubjectAlreadyExistsException.ofCode(subjectCreateDTO.code()));

    // Create a new subject using the factory
    final var newSubject = subjectFactory.create(subjectCreateDTO);

    // Save the new subject to the repository
    subjectRepository.save(newSubject);

    // Map the new subject to a SubjectLiteDTO and return it
    return subjectMapper.toSubjectLiteDTO(newSubject);
  }
}
