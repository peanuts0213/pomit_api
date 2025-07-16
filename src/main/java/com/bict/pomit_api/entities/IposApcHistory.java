package com.bict.pomit_api.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ipos_apc_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class IposApcHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ipos_apc_history_iah_idx_seq")
  @SequenceGenerator(name = "ipos_apc_history_iah_idx_seq", sequenceName = "ipos_apc_history_iah_idx_seq", allocationSize = 1)
  @Column(name = "iah_idx")
  private Long iahIdx;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "iai_idx", nullable = false)
  private IposApcInfo iposApcInfo;

  @Column(name = "iah_in", nullable = false)
  private Long iahIn;

  @Column(name = "iah_out", nullable = false)
  private Long iahOut;

  @Column(name = "iah_total", nullable = false)
  private Long iahTotal;

  @Column(name = "iah_datetime", nullable = false)
  private LocalDateTime iahDateTime;

  @Column(name = "timecreated", nullable = false, insertable = false)
  private LocalDateTime timecreated;

  @Column(name = "timemodified", nullable = false, insertable = false)
  private LocalDateTime timemodified;

}