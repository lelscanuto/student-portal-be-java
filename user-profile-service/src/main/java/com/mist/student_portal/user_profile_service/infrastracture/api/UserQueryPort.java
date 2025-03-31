package com.mist.student_portal.user_profile_service.infrastracture.api;

import com.mist.student_portal.user_profile_service.application.dto.response.UserLiteDTO;

public interface UserQueryPort {

  UserLiteDTO findUserByUserId(String userId);
}
