package com.example.hexagonal.external.domain.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Builder
@Accessors(chain = true)
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

	@Id
	private Long id;
	private String name;
	private String nameEn;
	private boolean isShown;
	private boolean isUsed;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TeamMemberEntity> teamMemberList = new ArrayList<>();
}
