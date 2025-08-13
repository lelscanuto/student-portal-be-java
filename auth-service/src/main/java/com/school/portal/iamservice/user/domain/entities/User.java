package com.school.portal.iamservice.user.domain.entities;

import com.school.portal.iamservice.department.domain.entities.Department;
import com.school.portal.iamservice.role.domain.entities.Role;
import jakarta.persistence.*;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class User {

  @Id
  @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username", nullable = false, unique = true, length = 100)
  private String username;

  @Column(name = "password", nullable = false, length = 255)
  private String password;

  @Column(name = "email", nullable = false, length = 100)
  private String email;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "user_department",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "department_id"))
  private Set<Department> department;
}
