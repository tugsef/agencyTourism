package com.tourism.agency.business.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LoginRequest {
	  @NotBlank
	  private String username;

	  @NotBlank
	  private String password;
}
