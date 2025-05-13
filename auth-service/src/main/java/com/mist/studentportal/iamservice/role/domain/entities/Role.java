package com.mist.studentportal.iamservice.role.domain.entities;

import com.mist.studentportal.iamservice.permission.domain.entities.Permission;
import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Role {

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

  @Column(name = "last_modified_date", nullable = false)
  @LastModifiedDate
  @CreatedDate
  private String lastModifiedDate;

  @Column(name = "created_date", nullable = false)
  @CreatedBy
  private String createdBy;

  @Column(name = "last_modified_by", nullable = false)
  @LastModifiedBy
  private String lastModifiedBy;

  @ManyToMany
  @JoinTable(
      name = "role_permission",
      joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id"))
  private Set<Permission> permissions;

  public boolean isPermissionDoesExists(Permission permission) {
    return this.permissions.stream()
        .map(Permission::getId)
        .anyMatch(existingPermissionId -> existingPermissionId.equals(permission.getId()));
  }

  public void addPermission(Set<Permission> existingPermissions) {
    this.permissions.addAll(existingPermissions);
  }

  public void removePermission(Set<Permission> permissions) {
    this.permissions.removeAll(permissions);
  }
}
