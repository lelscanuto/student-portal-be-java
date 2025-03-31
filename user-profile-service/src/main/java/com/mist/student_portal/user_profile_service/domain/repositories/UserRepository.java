package com.mist.student_portal.user_profile_service.domain.repositories;

import com.mist.student_portal.user_profile_service.domain.entities.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByUserId(String userId);
}
