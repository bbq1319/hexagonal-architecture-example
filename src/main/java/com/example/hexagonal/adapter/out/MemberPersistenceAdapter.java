package com.example.hexagonal.adapter.out;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.hexagonal.adapter.in.dto.GetMemberListCommand;
import com.example.hexagonal.application.port.out.GetMemberListPort;
import com.example.hexagonal.application.port.out.GetMemberOnePort;
import com.example.hexagonal.application.port.out.ModifyMemberPort;
import com.example.hexagonal.domain.model.Member;
import com.example.hexagonal.external.domain.entity.MemberEntity;
import com.example.hexagonal.persistence.MemberRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class MemberPersistenceAdapter implements GetMemberListPort, GetMemberOnePort, ModifyMemberPort {

	private final MemberPersistenceMapper memberMapper;
	private final MemberRepository memberRepository;

	@Override
	public Page<Member> getList(GetMemberListCommand command, Pageable pageable) {
		List<Member> results = memberRepository.findAll()
			.stream()
			.filter(MemberEntity::isUsed)
			.map(memberMapper::mapToDomain)
			.toList();
		return new PageImpl<>(results, pageable, results.size());
	}

	@Override
	public Member getOne(Long id) {
		MemberEntity member = memberRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Member not found"));
		return memberMapper.mapToDomain(member);
	}

	@Override
	public void modify(Member member) {
		memberRepository.save(memberMapper.mapToEntity(member));
	}
}
