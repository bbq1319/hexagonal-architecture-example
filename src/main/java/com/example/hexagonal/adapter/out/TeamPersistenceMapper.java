package com.example.hexagonal.adapter.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexagonal.domain.model.Member;
import com.example.hexagonal.domain.model.Team;
import com.example.hexagonal.external.domain.entity.TeamEntity;
import com.example.hexagonal.external.domain.entity.TeamMemberEntity;

@Component
class TeamPersistenceMapper {

	Team mapToDomain(TeamEntity teamEntity) {
		return Optional.of(teamEntity)
			.map(each -> Team.builder()
				.id(each.getId())
				.name(each.getName())
				.nameEn(each.getNameEn())
				.isShown(each.isShown())
				.isUsed(each.isUsed())
				.member(mapToMember(each.getTeamMemberList()))
				.build()
			)
			.orElse(null);
	}

	List<Member> mapToMember(List<TeamMemberEntity> teamMemberList) {
		List<Member> mappedMemberList = new ArrayList<>();

		for (TeamMemberEntity entity : teamMemberList) {
			mappedMemberList.add(Member.builder()
				.id(entity.getMember().getId())
				.name(entity.getMember().getName())
				.nameEn(entity.getMember().getNameEn())
				.isShown(entity.getMember().isShown())
				.isUsed(entity.getMember().isUsed())
				.role(entity.getRole())
				.build()
			);
		}

		return mappedMemberList;
	}
}
