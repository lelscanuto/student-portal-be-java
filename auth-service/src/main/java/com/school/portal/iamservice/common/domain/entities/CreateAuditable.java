package com.school.portal.iamservice.common.domain.entities;

import jakarta.persistence.MappedSuperclass;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class CreateAuditable {

  @CreatedDate private ZonedDateTime createdDate;
  @CreatedBy private String createdBy;
}
