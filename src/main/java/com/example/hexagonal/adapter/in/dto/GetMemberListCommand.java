package com.example.hexagonal.adapter.in.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public record GetMemberListCommand(Long id, String name, boolean isShown) {

	@Builder
	public GetMemberListCommand {
	}
}
