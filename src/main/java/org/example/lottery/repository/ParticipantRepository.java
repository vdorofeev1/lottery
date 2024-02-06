package org.example.lottery.repository;

import jakarta.transaction.Transactional;
import org.example.lottery.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE participant ALTER COLUMN id RESTART WITH 1", nativeQuery = true)
    void resetIdCounter();
}

