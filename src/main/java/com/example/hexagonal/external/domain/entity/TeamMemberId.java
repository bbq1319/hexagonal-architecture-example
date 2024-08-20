package com.example.hexagonal.external.domain.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"team", "member"})
public class TeamMemberId implements Serializable {

	private Long team;
	private Long member;
}
