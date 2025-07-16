package com.bict.pomit_api.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.bict.pomit_api.constants.KafkaTopic;
import com.bict.pomit_api.dto.kafka.consumer.PostApcLogDto;
import com.bict.pomit_api.service.KafkaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

  private final KafkaService kafkaService;

  @KafkaListener(topics = KafkaTopic.POST_APC_LOG, groupId = "pomit_api_${random.value}", properties = {
      "spring.json.value.default.type=com.bict.pomit_api.dto.kafka.consumer.PostApcLogDto",
      "spring.json.trusted.packages=*"
  })
  public void listen(PostApcLogDto dto) {
    kafkaService.postApcHistory(dto);
  }
}
