package com.example.hexagonal.adapter.out;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.hexagonal.domain.model.Member;
import com.example.hexagonal.domain.model.Team;
import com.example.hexagonal.external.domain.entity.MemberEntity;
import com.example.hexagonal.external.domain.entity.TeamEntity;
import com.example.hexagonal.external.domain.entity.TeamMemberEntity;

@Component
class MemberPersistenceMapper {

	Member mapToDomain(MemberEntity memberEntity) {
		TeamMemberEntity teamMember = memberEntity.getTeamMemberList()
			.stream()
			.findFirst()
			.orElseThrow();

		return Member.builder()
			.id(memberEntity.getId())
			.name(memberEntity.getName())
			.nameEn(memberEntity.getNameEn())
			.isShown(memberEntity.isShown())
			.isUsed(memberEntity.isUsed())
			.role(teamMember.getRole())
			.team(mapToTeam(teamMember))
			.build();
	}

	Team mapToTeam(TeamMemberEntity teamMember) {
		return Team.builder()
			.id(teamMember.getTeam().getId())
			.name(teamMember.getTeam().getName())
			.nameEn(teamMember.getTeam().getNameEn())
			.isShown(teamMember.getTeam().isShown())
			.isUsed(teamMember.getTeam().isUsed())
			.build();
	}

	MemberEntity mapToEntity(Member member) {
		return MemberEntity.builder()
			.id(member.getId())
			.name(member.getName())
			.nameEn(member.getNameEn())
			.isShown(member.isShown())
			.isUsed(member.isUsed())
			.teamMemberList(List.of(mapToTeamMember(member)))
			.build();
	}

	TeamMemberEntity mapToTeamMember(Member member) {
		TeamEntity teamEntity = TeamEntity.builder()
			.id(member.getTeam().getId())
			.build();
		MemberEntity memberEntity = MemberEntity.builder()
			.id(member.getId())
			.build();
		return TeamMemberEntity.builder()
			.team(teamEntity)
			.member(memberEntity)
			.role(member.getRole())
			.build();
	}
}
