package com.example.hexagonal.adapter.in.dto;

import com.example.hexagonal.external.domain.enumeration.PeopleRole;

import lombok.Builder;

@Builder
public record ModifyMemberCommand(Long id, boolean isShown, String name, String nameEn, Long teamId, PeopleRole role) {

	// 유효성 검사 코드
}
