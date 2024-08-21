package com.example.hexagonal.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hexagonal.application.port.in.GetMemberListCommand;
import com.example.hexagonal.application.port.in.GetMemberListUseCase;
import com.example.hexagonal.application.port.out.GetMemberListPort;
import com.example.hexagonal.domain.model.Member;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
class GetMemberListService implements GetMemberListUseCase {

	private final GetMemberListPort getMemberListPort;

	@Override
	public Page<Member> getMemberList(GetMemberListCommand command, Pageable pageable) {
		return getMemberListPort.getList(command, pageable);
	}
}
