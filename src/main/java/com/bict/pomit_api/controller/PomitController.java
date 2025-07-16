package com.bict.pomit_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bict.pomit_api.dto.kafka.producer.PomitRefreshDto;
import com.bict.pomit_api.dto.pomit.request.RequestApcHistoryDto;
import com.bict.pomit_api.dto.pomit.response.ResponseApcHistoryDto;
import com.bict.pomit_api.service.KafkaService;
import com.bict.pomit_api.service.PomitService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pomit")
public class PomitController {

  private final PomitService pomitService;
  private final KafkaService kafkaService;

  @GetMapping("/refresh")
  public ResponseEntity<PomitRefreshDto> refresh() {
    PomitRefreshDto pomitRefreshDto = pomitService.refresh();
    kafkaService.pomitRefresh(pomitRefreshDto);
    return ResponseEntity.ok(pomitService.refresh());
  }

  @PostMapping("/apc_history")
  public ResponseEntity<ResponseApcHistoryDto> postApcHistory(
      @RequestBody RequestApcHistoryDto dto) {
    return ResponseEntity.ok(pomitService.postApcHistory(dto));
  }

  @GetMapping("/test_insert")
  public ResponseEntity<ResponseApcHistoryDto> getMethodName() {
    return ResponseEntity.ok(pomitService.testInsert());
  }

}
