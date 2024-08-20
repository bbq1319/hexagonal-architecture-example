package com.example.hexagonal.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hexagonal.adapter.in.dto.ModifyMemberCommand;
import com.example.hexagonal.application.port.in.ModifyMemberUseCase;
import com.example.hexagonal.application.port.out.GetMemberOnePort;
import com.example.hexagonal.domain.model.Member;
import com.example.hexagonal.domain.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ModifyMemberService implements ModifyMemberUseCase {

	private final GetMemberOnePort getMemberOnePort;
	private final MemberService memberService;

	@Override
	public void modify(ModifyMemberCommand command) {
		Member exists = getMemberOnePort.getOne(command.id());

		if (memberService.canChangeTeam(exists, command.teamId(), command.role())) {
			exists.updateRole(command.role());
			exists.updateTeam(command.teamId());
		}

		exists.update(command);
	}
}
