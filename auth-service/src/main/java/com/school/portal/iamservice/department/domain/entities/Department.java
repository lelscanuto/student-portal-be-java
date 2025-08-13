package com.school.portal.iamservice.department.domain.entities;

import com.school.portal.common.domain.AuditMetadata;
import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Entity
@Table(name = "department")
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

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "description", nullable = false)
  private String description;

  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
  private Set<Organisation> organisations;

  @Embedded private AuditMetadata auditMetadata;

  public void addOrganisation(Organisation organisation) {
    if (organisation != null) {
      organisation.setDepartment(this);
      this.organisations.add(organisation);
    }
  }
}
