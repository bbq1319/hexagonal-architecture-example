package com.example.hexagonal.application.port.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.hexagonal.adapter.in.dto.GetMemberListCommand;
import com.example.hexagonal.domain.model.Member;

public interface GetMemberListPort {

	Page<Member> getList(GetMemberListCommand command, Pageable pageable);
}
