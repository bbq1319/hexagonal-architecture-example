package com.example.hexagonal.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hexagonal.external.domain.entity.TeamEntity;

@Repository
interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
