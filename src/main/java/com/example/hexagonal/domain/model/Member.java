package com.example.hexagonal.domain.model;

import com.example.hexagonal.application.port.in.ModifyMemberCommand;
import com.example.hexagonal.external.domain.enumeration.PeopleRole;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

	private Long id;
	private String name;
	private String nameEn;
	private boolean isShown;
	private boolean isUsed;
	private PeopleRole role;
	private Team team;

	public boolean canChangeTeam(Long teamId, PeopleRole role) {
		return !this.team.getId().equals(teamId) || (this.role == PeopleRole.CEO && !this.role.equals(role));
	}

	public void updateRole(PeopleRole role) {
		this.role = role;
	}

	public void updateTeam(Long teamId) {
		this.team.changeTeam(teamId);
	}

	public void update(ModifyMemberCommand command) {
		this.name = command.name();
		this.nameEn = command.nameEn();
		this.isShown = command.isShown();
	}
}
