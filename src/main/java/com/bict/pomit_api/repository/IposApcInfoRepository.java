package com.bict.pomit_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bict.pomit_api.entities.IposApcInfo;

@Repository
public interface IposApcInfoRepository extends JpaRepository<IposApcInfo, Long> {

}
