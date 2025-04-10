package org.example.springtask1.persistence.repository;

import org.example.springtask1.persistence.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {

    @Override
    List<Setting> findAll();
}
