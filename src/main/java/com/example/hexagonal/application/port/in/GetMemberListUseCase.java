package com.example.hexagonal.application.port.in;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.hexagonal.adapter.in.dto.GetMemberListCommand;
import com.example.hexagonal.domain.model.Member;

public interface GetMemberListUseCase {

	Page<Member> getMemberList(GetMemberListCommand command, Pageable pageable);
}
