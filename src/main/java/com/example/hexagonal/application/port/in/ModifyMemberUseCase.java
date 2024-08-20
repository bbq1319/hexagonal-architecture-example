package com.example.hexagonal.application.port.in;

import com.example.hexagonal.adapter.in.dto.ModifyMemberCommand;

public interface ModifyMemberUseCase {

	void modify(ModifyMemberCommand command);
}
