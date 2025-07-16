package com.bict.pomit_api.dto.pomit.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestApcHistoryDto {
  private Long iaiIdx;
  private Long iahIn;
  private Long iahOut;
  private Long iahTotal;
  private LocalDateTime iahDateTime;
}
