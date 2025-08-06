package com.mist.portal.academic.service.subjects.application.use_cases.impl;

import com.mist.portal.academic.service.subjects.application.dto.SubjectLiteDTO;
import com.mist.portal.academic.service.subjects.application.mappers.SubjectMapper;
import com.mist.portal.academic.service.subjects.application.use_cases.SubjectRemovalUseCase;
import com.mist.portal.academic.service.subjects.domain.exceptions.SubjectNotFoundException;
import com.mist.portal.academic.service.subjects.domain.repositories.SubjectRepository;
import com.mist.portal.academic.service.subjects.domain.services.SubjectDomainService;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the SubjectRemovalUseCase interface, providing functionality to remove
 * subjects. This service marks a subject as deleted rather than physically removing it from the
 * database.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SubjectRemovalUseCaseImpl implements SubjectRemovalUseCase {

  private final SubjectRepository subjectRepository;
  private final SubjectMapper subjectMapper;
  private final SubjectDomainService subjectDomainService;

  public SubjectRemovalUseCaseImpl(
      SubjectRepository subjectRepository,
      SubjectMapper subjectMapper,
      SubjectDomainService subjectDomainService) {
    this.subjectRepository = subjectRepository;
    this.subjectMapper = subjectMapper;
    this.subjectDomainService = subjectDomainService;
  }

  /**
   * Removes a subject by its ID, marking it as deleted.
   *
   * @param id the ID of the subject to be removed
   * @return a SubjectLiteDTO representing the removed subject
   * @throws SubjectNotFoundException if the subject with the given ID does not exist
   */
  @Override
  public SubjectLiteDTO remove(@Nonnull Long id) {

    // Fetch the existing subject by ID, throwing an exception if not found
    final var existingSubject =
        subjectRepository.findById(id).orElseThrow(() -> SubjectNotFoundException.of(id));

    // Assert that the subject is not deleted before removing
    subjectDomainService.removeSubject(existingSubject);

    // Save the updated subject back to the repository
    subjectRepository.save(existingSubject);

    // Return the removed subject as a SubjectLiteDTO
    return subjectMapper.toSubjectLiteDTO(existingSubject);
  }
}
