package com.bict.pomit_api.service;

import org.springframework.stereotype.Service;

import com.bict.pomit_api.dto.kafka.producer.PomitRefreshDto;
import com.bict.pomit_api.dto.pomit.request.RequestApcHistoryDto;
import com.bict.pomit_api.dto.pomit.response.ResponseApcHistoryDto;
import com.bict.pomit_api.entities.IposApcHistory;
import com.bict.pomit_api.entities.IposApcInfo;
import com.bict.pomit_api.entities.IposCctvInfo;
import com.bict.pomit_api.repository.IposApcHistoryRepository;
import com.bict.pomit_api.repository.IposApcInfoRepository;
import com.bict.pomit_api.repository.IposCctvInfoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PomitService {

  private final IposApcInfoRepository iposApcInfoRepository;
  private final IposApcHistoryRepository iposApcHistoryRepository;
  private final IposCctvInfoRepository iposCctvInfoRepository;

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public PomitRefreshDto refresh() {
    List<IposApcInfo> iposApcInfoList = iposApcInfoRepository.findAll();

    List<IposCctvInfo> iposCctvInfoList = iposApcInfoList.stream().flatMap(
        apcInfo -> iposCctvInfoRepository.findByIaiIdx(apcInfo.getIaiIdx()).stream()).collect(Collectors.toList());

    PomitRefreshDto pomitRefreshDto = new PomitRefreshDto(iposCctvInfoList, iposApcInfoList);

    return pomitRefreshDto;
  }

  @Transactional
  public ResponseApcHistoryDto testInsert() {
    // 1. 가장 최근 데이터 조회 (iah_datetime 기준 또는 iah_idx 기준)
    Optional<IposApcHistory> latestOpt = iposApcHistoryRepository
        .findTopByOrderByIahDateTimeDesc();

    if (latestOpt.isEmpty()) {
      new ResponseApcHistoryDto();
    }

    IposApcHistory latest = latestOpt.get();

    // 2. 새로운 엔티티 생성 및 값 복사
    IposApcHistory newHistory = new IposApcHistory();
    newHistory.setIposApcInfo(latest.getIposApcInfo());
    newHistory.setIahIn(latest.getIahIn());
    newHistory.setIahOut(latest.getIahOut());
    newHistory.setIahTotal(latest.getIahTotal());
    newHistory.setIahDateTime(latest.getIahDateTime());
    iposApcHistoryRepository.save(newHistory);
    iposApcHistoryRepository.flush();
    entityManager.refresh(newHistory);

    // 3. 저장
    return new ResponseApcHistoryDto(newHistory);
  }

  @Transactional
  public ResponseApcHistoryDto postApcHistory(RequestApcHistoryDto dto) {
    IposApcInfo iposApcInfo = iposApcInfoRepository.findById(dto.getIaiIdx().longValue()).get();

    IposApcHistory newApcHistory = new IposApcHistory();

    newApcHistory.setIposApcInfo(iposApcInfo);
    newApcHistory.setIahIn(dto.getIahIn());
    newApcHistory.setIahOut(dto.getIahOut());
    newApcHistory.setIahTotal(dto.getIahTotal());
    newApcHistory.setIahDateTime(dto.getIahDateTime());

    return new ResponseApcHistoryDto(iposApcHistoryRepository.save(newApcHistory));
  }
}
