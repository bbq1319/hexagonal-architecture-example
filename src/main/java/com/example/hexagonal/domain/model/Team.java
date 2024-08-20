package com.example.hexagonal.domain.model;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Team {

	private Long id;
	private String name;
	private String nameEn;
	private boolean isShown;
	private boolean isUsed;
	private List<Member> member;

	public void changeTeam(Long id) {
		this.id = id;
	}
}
