package com.bict.pomit_api.dto.kafka.producer;

import com.bict.pomit_api.entities.IposApcInfo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IposApcInfoDto {
  private Long iaiIdx;
  private String iaiName;

  public IposApcInfoDto(IposApcInfo iposCctvInfo) {
    this.iaiIdx = iposCctvInfo.getIaiIdx();
    this.iaiName = iposCctvInfo.getIaiName();
  }
}
