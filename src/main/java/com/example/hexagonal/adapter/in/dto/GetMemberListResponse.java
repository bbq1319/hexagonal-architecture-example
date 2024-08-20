package com.example.hexagonal.adapter.in.dto;

import com.example.hexagonal.domain.model.Member;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class GetMemberListResponse {

	private Long id;
	private String name;
	private String nameEn;
	private boolean isShown;
	private Long teamId;
	private String teamName;

	public GetMemberListResponse(Member member) {
		this.id = member.getId();
		this.name = member.getName();
		this.nameEn = member.getNameEn();
		this.isShown = member.isShown();
		this.teamId = member.getTeam().getId();
		this.teamName = member.getTeam().getName();
	}
}
