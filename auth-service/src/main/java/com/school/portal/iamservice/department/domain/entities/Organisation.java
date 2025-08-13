package com.school.portal.iamservice.department.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "organisation")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Organisation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "description", nullable = false)
  private String description;

  @ManyToOne
  @JoinColumn(name = "department_id", nullable = false)
  private Department department;
}
