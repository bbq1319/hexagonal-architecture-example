package com.example.hexagonal.application.port.out;

import com.example.hexagonal.domain.model.Team;

public interface GetTeamOnePort {

	Team getOne(Long id);
}
