package com.school.portal.iamservice.department.domain.entities;

import com.school.portal.common.domain.AuditMetadata;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "department",
    indexes = @Index(name = "idx_department_code", columnList = "code", unique = true))
@EqualsAndHashCode
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "code", nullable = false, unique = true)
  private String code;

  @Column(name = "description", nullable = false)
  private String description;

  @Embedded private AuditMetadata auditMetadata;
}
