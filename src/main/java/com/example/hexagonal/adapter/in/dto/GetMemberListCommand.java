package com.example.hexagonal.adapter.in.dto;

import lombok.Builder;

@Builder
public record GetMemberListCommand(Long id, String name, boolean isShown) {

	// 유효성 검사 코드
}
