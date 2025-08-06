package com.school.portal.iamservice.permission.domain.entities;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "permissions")
@AllArgsConstructor
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Permission {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, unique = true, length = 100)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "created_date", nullable = false)
  @CreatedDate
  private ZonedDateTime createdDate;

  @Column(name = "created_date", nullable = false)
  @CreatedBy
  private String createdBy;
}
