package com.bict.pomit_api.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ipos_apc_info")
@Data
public class IposApcInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ipos_apc_info_iai_idx_seq")
  @SequenceGenerator(name = "ipos_apc_info_iai_idx_seq", sequenceName = "ipos_apc_info_iai_idx_seq", allocationSize = 1)
  @Column(name = "iai_idx")
  private Long iaiIdx;

  @Column(name = "igi_idx", nullable = false)
  private Long igiIdx;

  @Column(name = "iai_name", nullable = false, length = 255)
  private String iaiName;

  @Column(name = "iai_location", nullable = false, length = 255)
  private String iaiLocation;

  @Column(name = "iai_code", length = 100)
  private String iaiCode;

  @Column(name = "timecreated", nullable = false)
  private LocalDateTime timecreated;

  @Column(name = "timemodified", nullable = false)
  private LocalDateTime timemodified;

  // 1:N 관계 설정 (ipos_apc_history와 연결)
  @OneToMany(mappedBy = "iposApcInfo", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<IposApcHistory> histories = new ArrayList<>();
}