package com.example.hexagonal.adapter.in.dto;

import com.example.hexagonal.external.domain.enumeration.PeopleRole;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyMemberRequest {

	@NotNull
	private boolean isShown;
	@NotEmpty
	private String name;
	private String nameEn;
	@NotEmpty
	private Long teamId;
	@NotNull
	private PeopleRole role;
}
