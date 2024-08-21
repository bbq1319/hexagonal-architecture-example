package com.example.hexagonal.adapter.out;

import org.springframework.stereotype.Component;

import com.example.hexagonal.application.port.out.GetTeamOnePort;
import com.example.hexagonal.domain.model.Team;
import com.example.hexagonal.external.domain.entity.TeamEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TeamPersistenceAdapter implements GetTeamOnePort {

	private final TeamPersistenceMapper teamMapper;
	private final TeamRepository teamRepository;

	@Override
	public Team getOne(Long id) {
		TeamEntity team = teamRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Team not found"));
		return teamMapper.mapToDomain(team);
	}
}
