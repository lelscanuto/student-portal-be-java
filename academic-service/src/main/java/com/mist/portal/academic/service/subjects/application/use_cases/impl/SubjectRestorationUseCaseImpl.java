package com.mist.portal.academic.service.subjects.application.use_cases.impl;

import com.mist.portal.academic.service.subjects.application.dto.SubjectLiteDTO;
import com.mist.portal.academic.service.subjects.application.mappers.SubjectMapper;
import com.mist.portal.academic.service.subjects.application.use_cases.SubjectRestorationUseCase;
import com.mist.portal.academic.service.subjects.domain.exceptions.SubjectNotFoundException;
import com.mist.portal.academic.service.subjects.domain.repositories.SubjectRepository;
import com.mist.portal.academic.service.subjects.domain.services.SubjectDomainService;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the SubjectRestorationUseCase interface, providing functionality to restore
 * previously deleted subjects.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SubjectRestorationUseCaseImpl implements SubjectRestorationUseCase {

  private final SubjectDomainService subjectDomainService;
  private final SubjectRepository subjectRepository;
  private final SubjectMapper subjectMapper;

  public SubjectRestorationUseCaseImpl(
      SubjectDomainService subjectDomainService,
      SubjectRepository subjectRepository,
      SubjectMapper subjectMapper) {
    this.subjectDomainService = subjectDomainService;
    this.subjectRepository = subjectRepository;
    this.subjectMapper = subjectMapper;
  }

  /**
   * Restores a previously deleted subject by setting its deleted state to false.
   *
   * @param id the ID of the subject to be restored
   * @return a SubjectLiteDTO representing the restored subject
   * @throws SubjectNotFoundException if the subject with the given ID does not exist
   */
  @Override
  public SubjectLiteDTO restore(@Nonnull Long id) {

    // Fetch the existing subject by ID, throwing an exception if not found
    final var existingSubject =
        subjectRepository.findById(id).orElseThrow(() -> SubjectNotFoundException.of(id));

    // Assert that the subject is deleted before restoring
    subjectDomainService.restoreSubject(existingSubject);

    // Save the restored subject back to the repository
    subjectRepository.save(existingSubject);

    // Return the restored subject as a SubjectLiteDTO
    return subjectMapper.toSubjectLiteDTO(existingSubject);
  }
}
