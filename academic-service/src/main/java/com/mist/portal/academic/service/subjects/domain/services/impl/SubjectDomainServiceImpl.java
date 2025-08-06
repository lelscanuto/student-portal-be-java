package com.mist.portal.academic.service.subjects.domain.services.impl;

import static com.school.portal.common.utils.AssertUtil.isFalse;

import com.mist.portal.academic.service.subjects.application.dto.SubjectUpdateDTO;
import com.mist.portal.academic.service.subjects.domain.entities.Subject;
import com.mist.portal.academic.service.subjects.domain.enums.SubjectOperation;
import com.mist.portal.academic.service.subjects.domain.exceptions.SubjectStateInvalidException;
import com.mist.portal.academic.service.subjects.domain.services.SubjectDomainService;
import com.school.portal.common.utils.AssertUtil;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the SubjectDomainService interface for managing subject updates. This service
 * handles the business logic for updating a subject's properties.
 */
@Service
@Transactional(propagation = Propagation.MANDATORY)
public class SubjectDomainServiceImpl implements SubjectDomainService {

  /**
   * Updates the properties of an existing subject based on the provided SubjectUpdateDTO.
   *
   * @param existingSubject the subject to be updated
   * @param subjectUpdateDTO the DTO containing the updated properties of the subject
   * @throws SubjectStateInvalidException if the subject is marked as deleted
   */
  @Override
  public void updateSubject(@Nonnull Subject existingSubject, SubjectUpdateDTO subjectUpdateDTO) {

    // Assert that the subject is not deleted before proceeding with the update
    isFalse(existingSubject.isDeleted())
        .elseThrow(
            () ->
                SubjectStateInvalidException.of(existingSubject.getCode())
                    .operation(SubjectOperation.FOR_UPDATE)
                    .isDeleted()
                    .build());

    // Update the subject's properties with the values from the DTO
    existingSubject.setUnits(subjectUpdateDTO.units());
    existingSubject.setTitle(subjectUpdateDTO.title());
    existingSubject.setDescription(subjectUpdateDTO.description());
  }

  /**
   * Restores a previously deleted subject by setting its deleted state to false.
   *
   * @param existingSubject the subject to be restored
   * @throws SubjectStateInvalidException if the subject is not marked as deleted
   */
  @Override
  public void restoreSubject(@Nonnull Subject existingSubject) {

    // Assert that the subject is deleted before restoring
    AssertUtil.isTrue(existingSubject.isDeleted())
        .elseThrow(
            () ->
                SubjectStateInvalidException.of(existingSubject.getCode())
                    .operation(SubjectOperation.FOR_RESTORE)
                    .build());

    // Restore the subject by setting its deleted state to false
    existingSubject.setDeleted(false);
  }

  /**
   * Marks a subject as deleted by setting its deleted state to true.
   *
   * @param existingSubject the subject to be marked as deleted
   * @throws SubjectStateInvalidException if the subject is already marked as deleted
   */
  @Override
  public void removeSubject(@Nonnull Subject existingSubject) {

    // Assert that the subject is not deleted before proceeding with the update
    isFalse(existingSubject.isDeleted())
        .elseThrow(
            () ->
                SubjectStateInvalidException.of(existingSubject.getCode())
                    .operation(SubjectOperation.FOR_DELETE)
                    .isDeleted()
                    .build());

    // Mark the subject as deleted
    existingSubject.setDeleted(true);
  }
}
