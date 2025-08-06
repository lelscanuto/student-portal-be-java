package com.mist.portal.academic.service.subjects.application.facade.impl;

import com.mist.portal.academic.service.subjects.application.dto.SubjectCreateDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectLiteDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectUpdateDTO;
import com.mist.portal.academic.service.subjects.application.facade.SubjectManagementApplication;
import com.mist.portal.academic.service.subjects.application.use_cases.SubjectCreationUseCase;
import com.mist.portal.academic.service.subjects.application.use_cases.SubjectRemovalUseCase;
import com.mist.portal.academic.service.subjects.application.use_cases.SubjectRestorationUseCase;
import com.mist.portal.academic.service.subjects.application.use_cases.SubjectUpdateUseCase;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;

@Service
public class SubjectManagementApplicationImpl implements SubjectManagementApplication {

  private final SubjectCreationUseCase subjectCreationUseCase;
  private final SubjectUpdateUseCase subjectUpdateUseCase;
  private final SubjectRemovalUseCase subjectRemovalUseCase;
  private final SubjectRestorationUseCase subjectRestorationUseCase;

  public SubjectManagementApplicationImpl(
      SubjectCreationUseCase subjectCreationUseCase,
      SubjectUpdateUseCase subjectUpdateUseCase,
      SubjectRemovalUseCase subjectRemovalUseCase,
      SubjectRestorationUseCase subjectRestorationUseCase) {
    this.subjectCreationUseCase = subjectCreationUseCase;
    this.subjectUpdateUseCase = subjectUpdateUseCase;
    this.subjectRemovalUseCase = subjectRemovalUseCase;
    this.subjectRestorationUseCase = subjectRestorationUseCase;
  }

  /**
   * Adds a new subject based on the provided SubjectCreateDTO.
   *
   * @param subjectCreateDTO the DTO containing the details of the subject to be created
   * @return a SubjectLiteDTO representing the created subject
   */
  @Override
  public SubjectLiteDTO add(@Nonnull SubjectCreateDTO subjectCreateDTO) {
    return subjectCreationUseCase.create(subjectCreateDTO);
  }

  /**
   * Removes a subject by its ID.
   *
   * @param id the ID of the subject to be removed
   * @return a SubjectLiteDTO representing the removed subject
   */
  @Override
  public SubjectLiteDTO remove(@Nonnull Long id) {
    return subjectRemovalUseCase.remove(id);
  }

  /**
   * Updates an existing subject with the provided details.
   *
   * @param id the ID of the subject to update
   * @param subjectCreateDTO the DTO containing the updated details of the subject
   * @return a SubjectLiteDTO representing the updated subject
   */
  @Override
  public SubjectLiteDTO update(@Nonnull Long id, @Nonnull SubjectUpdateDTO subjectCreateDTO) {
    return subjectUpdateUseCase.update(id, subjectCreateDTO);
  }

  /**
   * Restores a previously removed subject by its ID.
   *
   * @param id the ID of the subject to restore
   * @return a SubjectLiteDTO representing the restored subject
   */
  @Override
  public SubjectLiteDTO restore(@Nonnull Long id) {
    return subjectRestorationUseCase.restore(id);
  }
}
