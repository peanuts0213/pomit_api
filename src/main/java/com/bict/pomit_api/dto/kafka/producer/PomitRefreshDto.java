package com.bict.pomit_api.dto.kafka.producer;

import java.util.List;
import java.util.stream.Collectors;

import com.bict.pomit_api.entities.IposApcInfo;
import com.bict.pomit_api.entities.IposCctvInfo;

import lombok.Data;

@Data
public class PomitRefreshDto {
  private List<IposCctvInfoDto> iposCctvInfoListDto;
  private List<IposApcInfoDto> iposApcInfoListDto;

  public PomitRefreshDto(List<IposCctvInfo> iposCctvInfoList, List<IposApcInfo> iposApcInfoList) {
    this.iposCctvInfoListDto = iposCctvInfoList.stream().map(IposCctvInfoDto::new).collect(Collectors.toList());
    this.iposApcInfoListDto = iposApcInfoList.stream().map(IposApcInfoDto::new).collect(Collectors.toList());
  }
}
