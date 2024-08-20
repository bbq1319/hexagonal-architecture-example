package com.example.hexagonal.adapter.in.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class GetMemberListRequest {

	private Long id;
	private String name;
	private boolean isShown;
}
