package com.example.hexagonal.adapter.in.dto;

import com.example.hexagonal.external.domain.enumeration.PeopleRole;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public record ModifyMemberCommand(Long id, boolean isShown, String name, String nameEn, Long teamId, PeopleRole role) {

	@Builder
	public ModifyMemberCommand {
	}
}
