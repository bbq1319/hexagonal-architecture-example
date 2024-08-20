package com.example.hexagonal.domain.service;

import org.springframework.stereotype.Service;

import com.example.hexagonal.application.port.out.GetTeamOnePort;
import com.example.hexagonal.domain.model.Member;
import com.example.hexagonal.domain.model.Team;
import com.example.hexagonal.external.domain.enumeration.PeopleRole;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

	private final GetTeamOnePort getTeamOnePort;

	public boolean canChangeTeam(Member member, Long teamId, PeopleRole role) {
		Team team = getTeamOnePort.getOne(teamId);
		long ceoCount = team.getMember()
			.stream()
			.filter(each -> !member.getId().equals(each.getId()))
			.filter(each -> each.getRole() == PeopleRole.CEO)
			.filter(Member::isUsed)
			.count();
		return member.canChangeTeam(teamId, role) && ceoCount != 0;
	}
}
