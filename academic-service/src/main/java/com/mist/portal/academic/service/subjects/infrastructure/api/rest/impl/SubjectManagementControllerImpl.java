package com.mist.portal.academic.service.subjects.infrastructure.api.rest.impl;

import com.mist.portal.academic.service.subjects.application.dto.SubjectCreateDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectLiteDTO;
import com.mist.portal.academic.service.subjects.application.dto.SubjectUpdateDTO;
import com.mist.portal.academic.service.subjects.application.facade.SubjectManagementApplication;
import com.mist.portal.academic.service.subjects.infrastructure.api.rest.SubjectManagementController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectManagementControllerImpl implements SubjectManagementController {

  private final SubjectManagementApplication subjectManagementApplication;

  public SubjectManagementControllerImpl(
      SubjectManagementApplication subjectManagementApplication) {
    this.subjectManagementApplication = subjectManagementApplication;
  }

  @Override
  @PostMapping
  public SubjectLiteDTO add(@RequestBody SubjectCreateDTO subjectCreateDTO) {
    return subjectManagementApplication.add(subjectCreateDTO);
  }

  @Override
  @PutMapping("/{id}")
  public SubjectLiteDTO update(
      @PathVariable("id") Long id, @RequestBody SubjectUpdateDTO subjectUpdateDTO) {
    return subjectManagementApplication.update(id, subjectUpdateDTO);
  }

  @Override
  @DeleteMapping("/{id}")
  public SubjectLiteDTO remove(@PathVariable("id") Long id) {
    return subjectManagementApplication.remove(id);
  }

  @Override
  @PutMapping("/{id}/restore")
  public SubjectLiteDTO restore(@PathVariable("id") Long id) {
    return subjectManagementApplication.restore(id);
  }
}
