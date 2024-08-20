package com.example.hexagonal.adapter.in;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal.adapter.in.dto.GetMemberListCommand;
import com.example.hexagonal.adapter.in.dto.GetMemberListRequest;
import com.example.hexagonal.adapter.in.dto.GetMemberListResponse;
import com.example.hexagonal.adapter.in.dto.ModifyMemberCommand;
import com.example.hexagonal.adapter.in.dto.ModifyMemberRequest;
import com.example.hexagonal.application.port.in.GetMemberListUseCase;
import com.example.hexagonal.application.port.in.ModifyMemberUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
class MemberController {

	private final GetMemberListUseCase getMemberListUseCase;
	private final ModifyMemberUseCase modifyMemberUseCase;

	@GetMapping("/list")
	public Page<GetMemberListResponse> getList(GetMemberListRequest request, @PageableDefault Pageable pageable) {
		GetMemberListCommand command = GetMemberListCommand.builder()
			.id(request.getId())
			.name(request.getName())
			.isShown(request.isShown())
			.build();

		return getMemberListUseCase.getMemberList(command, pageable)
			.map(GetMemberListResponse::new);
	}

	@PostMapping("/{id}")
	public void modify(@PathVariable Long id, @Validated @RequestBody ModifyMemberRequest request) {
		ModifyMemberCommand command = ModifyMemberCommand.builder()
			.id(id)
			.isShown(request.isShown())
			.name(request.getName())
			.nameEn(request.getNameEn())
			.teamId(request.getTeamId())
			.role(request.getRole())
			.build();
		modifyMemberUseCase.modify(command);
	}
}
