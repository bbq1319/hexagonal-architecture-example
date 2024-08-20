package com.example.hexagonal.external.domain.entity;

import java.io.Serializable;

import com.example.hexagonal.external.domain.enumeration.PeopleRole;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@IdClass(TeamMemberId.class)
@Table(name = "team_member")
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberEntity implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private TeamEntity team;
	@Id
	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private MemberEntity member;
	private PeopleRole role;
}
