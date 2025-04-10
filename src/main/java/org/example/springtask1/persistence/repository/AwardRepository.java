package org.example.springtask1.persistence.repository;

import org.example.springtask1.persistence.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {

    @Override
    List<Award> findAll();
}
