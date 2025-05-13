package com.mist.studentportal.userprofileservice.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "roles")
@Getter
@Immutable
@NoArgsConstructor
public class RoleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "value", unique = true, updatable = false)
  private String value;

  @Column(name = "description")
  private String description;
}
