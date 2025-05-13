package com.mist.studentportal.userprofileservice.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
public class AddressEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "street")
  private String street;

  @Column(name = "unit_no")
  private String unitNo;

  @Column(name = "postal_code")
  private String postalCode;

  @Column(name = "city")
  private String city;

  @Column(name = "province")
  private String province;
}
