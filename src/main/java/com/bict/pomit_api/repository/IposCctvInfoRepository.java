package com.bict.pomit_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bict.pomit_api.entities.IposCctvInfo;

@Repository
public interface IposCctvInfoRepository extends JpaRepository<IposCctvInfo, Long> {
  List<IposCctvInfo> findByIaiIdx(Long iaiIdx);
}
