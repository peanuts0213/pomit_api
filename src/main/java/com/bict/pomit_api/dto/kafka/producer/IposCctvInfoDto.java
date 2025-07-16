package com.bict.pomit_api.dto.kafka.producer;

import com.bict.pomit_api.entities.IposCctvInfo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IposCctvInfoDto {
  private Long iciIdx;
  private Long iaiIdx;
  private String iciName;
  private String iciConnectUrl;

  public IposCctvInfoDto(IposCctvInfo iposCctvInfo) {
    this.iciIdx = iposCctvInfo.getIciIdx();
    this.iaiIdx = iposCctvInfo.getIaiIdx();
    this.iciName = iposCctvInfo.getIciName();
    this.iciConnectUrl = iposCctvInfo.getIciConnectUrl();
  }
};