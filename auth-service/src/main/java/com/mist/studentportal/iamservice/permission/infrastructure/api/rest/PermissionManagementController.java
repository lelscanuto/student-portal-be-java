package com.mist.studentportal.iamservice.permission.infrastructure.api.rest;

import com.mist.studentportal.iamservice.permission.application.dto.CreatePermissionDTO;
import com.mist.studentportal.iamservice.permission.application.dto.PermissionDetailDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.concurrent.CompletableFuture;

@Tag(name = "Permission API")
public interface PermissionManagementController {

  @Operation(summary = "Create Permission")
  @ApiResponse(
      responseCode = "201",
      description = "Success Permission Create",
      content = {
        @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = PermissionDetailDTO.class))
      })
  @ApiResponse(responseCode = "409", description = "Permission already exists", content = @Content)
  CompletableFuture<PermissionDetailDTO> create(@Valid CreatePermissionDTO createPermissionDTO);

  @Operation(summary = "Delete Permission")
  @ApiResponse(
      responseCode = "200",
      description = "Delete Existing Permission",
      content = {
        @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = PermissionDetailDTO.class))
      })
  @ApiResponse(responseCode = "404", description = "Permission not found")
  CompletableFuture<PermissionDetailDTO> delete(@Valid Long permissionId);
}
