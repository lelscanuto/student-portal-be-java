package com.school.portal.common.domain;

import jakarta.persistence.Embeddable;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class AuditMetadata {

  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private String createdBy;
  private String updatedBy;
}
