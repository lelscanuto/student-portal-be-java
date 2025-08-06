package com.mist.portal.academic.service.subjects.infrastructure.api.rest;

import com.mist.portal.academic.service.subjects.application.dto.SubjectCreateDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectLiteDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Subject Management", description = "APIs for managing subjects")
public interface SubjectManagementController {

  @Operation(
      summary = "Add a new subject",
      description = "Creates a new subject and returns its details.")
  SubjectLiteDTO add(
      @Parameter(description = "Subject creation data", required = true)
          SubjectCreateDTO subjectCreateDTO);

  @Operation(summary = "Update a subject", description = "Updates an existing subject by ID.")
  SubjectLiteDTO update(
      @Parameter(description = "ID of the subject to update", required = true) Long id,
      @Parameter(description = "Subject update data", required = true)
          SubjectUpdateDTO subjectUpdateDTO);

  @Operation(summary = "Remove a subject", description = "Removes a subject by ID (soft delete).")
  SubjectLiteDTO remove(
      @Parameter(description = "ID of the subject to remove", required = true) Long id);

  @Operation(
      summary = "Restore a subject",
      description = "Restores a previously removed subject by ID.")
  SubjectLiteDTO restore(
      @Parameter(description = "ID of the subject to restore", required = true) Long id);
}
