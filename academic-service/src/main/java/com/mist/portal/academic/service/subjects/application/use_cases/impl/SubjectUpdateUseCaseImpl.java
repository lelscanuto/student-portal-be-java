package com.mist.portal.academic.service.subjects.application.use_cases.impl;

import com.mist.portal.academic.service.subjects.application.dto.SubjectLiteDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectUpdateDTO;
import com.mist.portal.academic.service.subjects.application.mappers.SubjectMapper;
import com.mist.portal.academic.service.subjects.application.use_cases.SubjectUpdateUseCase;
import com.mist.portal.academic.service.subjects.domain.exceptions.SubjectNotFoundException;
import com.mist.portal.academic.service.subjects.domain.repositories.SubjectRepository;
import com.mist.portal.academic.service.subjects.domain.services.SubjectDomainService;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the SubjectUpdateUseCase interface, providing functionality to update existing
 * subjects.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SubjectUpdateUseCaseImpl implements SubjectUpdateUseCase {

  private final SubjectDomainService subjectDomainService;
  private final SubjectRepository subjectRepository;
  private final SubjectMapper subjectMapper;

  public SubjectUpdateUseCaseImpl(
      SubjectDomainService subjectDomainService,
      SubjectRepository subjectRepository,
      SubjectMapper subjectMapper) {
    this.subjectDomainService = subjectDomainService;
    this.subjectRepository = subjectRepository;
    this.subjectMapper = subjectMapper;
  }

  /**
   * Updates an existing subject with the provided details.
   *
   * @param id the ID of the subject to update
   * @param subjectUpdateDTO the DTO containing the updated details of the subject
   * @return a SubjectLiteDTO representing the updated subject
   * @throws SubjectNotFoundException if no subject with the given ID exists
   */
  @Override
  public SubjectLiteDTO update(@Nonnull Long id, @Nonnull SubjectUpdateDTO subjectUpdateDTO) {

    // Retrieve the existing subject by ID, throwing an exception if not found
    final var existingSubject =
        subjectRepository.findById(id).orElseThrow(() -> new SubjectNotFoundException(id));

    // Update the subject using the domain service
    subjectDomainService.updateSubject(existingSubject, subjectUpdateDTO);

    // Save the updated subject back to the repository
    subjectRepository.save(existingSubject);

    // Map the updated subject to a SubjectLiteDTO and return it
    return subjectMapper.toSubjectLiteDTO(existingSubject);
  }
}
