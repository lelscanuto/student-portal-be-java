package com.mist.portal.academic.service.subjects.domain.entities;

import com.school.portal.common.domain.AuditMetadata;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(
    name = "subject",
    indexes = @Index(name = "idx_subject_code", columnList = "code", unique = true))
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "code", nullable = false, unique = true, length = 20)
  private String code;

  @Column(name = "title", nullable = false, length = 100)
  private String title;

  @Column(name = "units", nullable = false)
  private Integer units;

  @Column(name = "deleted", nullable = false)
  private Boolean deleted = false;

  @Column(name = "description", length = 255)
  private String description;

  @Embedded private AuditMetadata auditMetadata = new AuditMetadata();

  public boolean isDeleted() {
    return deleted;
  }
}
