package org.example.lottery.repository;

import org.example.lottery.models.Winner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WinnerRepository extends JpaRepository<Winner, Long> {

}
