package com.example.hexagonal.application.port.out;

import com.example.hexagonal.domain.model.Member;

public interface ModifyMemberPort {

	void modify(Member member);
}
