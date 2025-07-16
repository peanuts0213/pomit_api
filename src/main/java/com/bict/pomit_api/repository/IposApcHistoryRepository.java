package com.bict.pomit_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bict.pomit_api.entities.IposApcHistory;

@Repository
public interface IposApcHistoryRepository extends JpaRepository<IposApcHistory, Long> {
  Optional<IposApcHistory> findTopByOrderByIahDateTimeDesc();
}