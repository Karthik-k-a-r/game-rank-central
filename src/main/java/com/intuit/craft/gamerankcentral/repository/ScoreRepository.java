package com.intuit.craft.gamerankcentral.repository;

import com.intuit.craft.gamerankcentral.model.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score,String> {
}
