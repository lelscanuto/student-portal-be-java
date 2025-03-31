package com.mist.student_portal.user_profile_service.domain.entities;

import com.mist.student_portal.user_profile_service.common.enums.UserStatus;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "users",
    indexes = {
      @Index(name = "idx_user_id", unique = true, columnList = "user_id"),
      @Index(name = "idx_user_email", unique = true, columnList = "email")
    })
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false, updatable = false)
  private Long userId; // Reference to auth-service user

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "middle_name", nullable = false)
  private String middleName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "birthdate", nullable = false)
  private Date birthdate;

  private UserStatus userStatus;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private UserPreferencesEntity preferences;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<UserContactEntity> contacts;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<UserAddressEntity> addresses;

  @ManyToMany
  @JoinTable(
      name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<RoleEntity> roles;
}
