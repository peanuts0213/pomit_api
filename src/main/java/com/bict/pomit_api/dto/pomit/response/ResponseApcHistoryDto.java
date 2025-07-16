package com.bict.pomit_api.dto.pomit.response;

import java.time.LocalDateTime;

import com.bict.pomit_api.entities.IposApcHistory;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseApcHistoryDto {
  private Long iahIdx;
  private Long iaiIdx;
  private Long iahIn;
  private Long iahOut;
  private Long iahTotal;
  private LocalDateTime iahDateTime;
  private LocalDateTime timecreated;
  private LocalDateTime timemodified;

  public ResponseApcHistoryDto(IposApcHistory iposApcHistory) {
    this.iahIdx = iposApcHistory.getIahIdx();
    this.iaiIdx = iposApcHistory.getIposApcInfo().getIaiIdx();
    this.iahIn = iposApcHistory.getIahIn();
    this.iahOut = iposApcHistory.getIahOut();
    this.iahTotal = iposApcHistory.getIahTotal();
    this.iahDateTime = iposApcHistory.getIahDateTime();
    this.timecreated = iposApcHistory.getTimecreated();
    this.timemodified = iposApcHistory.getTimemodified();
  }
}
