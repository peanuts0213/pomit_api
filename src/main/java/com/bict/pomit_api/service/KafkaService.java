package com.bict.pomit_api.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bict.pomit_api.constants.KafkaTopic;
import com.bict.pomit_api.dto.kafka.consumer.PostApcLogDto;
import com.bict.pomit_api.dto.kafka.producer.PomitRefreshDto;
import com.bict.pomit_api.dto.pomit.request.RequestApcHistoryDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaService {

  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final PomitService pomitService;

  public void send(String topic, Object message) {
    kafkaTemplate.send(topic, message)
        .thenAccept(result -> log.info("Kafka 전송 성공 [topic={}, offset={}]", topic,
            result.getRecordMetadata().offset()))
        .exceptionally(ex -> {
          log.warn("Kafka 전송 실패 [topic={}, error={}]", topic, ex.getMessage());
          return null;
        });
  }

  public void postApcHistory(PostApcLogDto dto) {
    pomitService.postApcHistory(new RequestApcHistoryDto(
        dto.getIaiIdx(),
        dto.getIahIn(),
        dto.getIahOut(),
        dto.getIahTotal(),
        dto.getIahDateTime()));
  }

  public void pomitRefresh(PomitRefreshDto pomitRefreshDto) {
    this.send(KafkaTopic.POMIT_REFRESH, pomitRefreshDto);
  }

}
