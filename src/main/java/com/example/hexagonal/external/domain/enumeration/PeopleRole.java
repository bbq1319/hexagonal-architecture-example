package com.example.hexagonal.external.domain.enumeration;

import lombok.Getter;

@Getter
public enum PeopleRole {

	CEO(1, "CEO"),
	CTO(2, "CTO"),
	CFO(3, "CFO");

	private final int code;
	private final String description;

	PeopleRole(int code, String description) {
		this.code = code;
		this.description = description;
	}
}
