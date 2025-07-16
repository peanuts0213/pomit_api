package com.bict.pomit_api.dto.kafka.consumer;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostApcLogDto {
  private Long cctvId;
  private Long logId;
  private Boolean isIn;
  private Long iaiIdx;
  private Long iahIn;
  private Long iahOut;
  private Long iahTotal;
  private LocalDateTime iahDateTime;
}
