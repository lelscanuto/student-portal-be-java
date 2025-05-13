package com.mist.studentportal.userprofileservice.domain.entities;

import com.mist.studentportal.userprofileservice.common.enums.AddressType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_address")
public class UserAddressEntity {

  @EmbeddedId private UserAddressEntityId id;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @MapsId("userEntityId")
  @JoinColumn(name = "user_entity_id", nullable = false)
  private UserEntity userEntity;

  @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
  @MapsId("addressId")
  @JoinColumn(name = "address_id", nullable = false)
  private AddressEntity address;

  @Column(name = "type", nullable = false)
  private AddressType type;

  @Embeddable
  @Getter
  @EqualsAndHashCode
  @NoArgsConstructor
  public static class UserAddressEntityId {

    private Long userEntityId;
    private Long addressId;

    public UserAddressEntityId(Long userEntityId, Long addressId) {
      this.userEntityId = userEntityId;
      this.addressId = addressId;
    }
  }
}
