package com.bict.pomit_api.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ipos_cctv_info")
@Data
public class IposCctvInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ipos_cctv_info_ici_idx_seq")
  @SequenceGenerator(name = "ipos_cctv_info_ici_idx_seq", sequenceName = "ipos_cctv_info_ici_idx_seq", allocationSize = 1)
  @Column(name = "ici_idx")
  private Long iciIdx;

  @Column(name = "igi_idx", nullable = false)
  private Long igiIdx;

  @Column(name = "iai_idx", nullable = true)
  private Long iaiIdx;

  @Column(name = "ici_name", nullable = false, length = 255)
  private String iciName;

  @Column(name = "ici_location", nullable = false, length = 255)
  private String iciLocation;

  @Column(name = "ici_location_code", length = 255)
  private String iciLocationCode;

  @Column(name = "ici_connect_url", nullable = false, length = 255)
  private String iciConnectUrl;

  @Column(name = "timecreated", nullable = false)
  private LocalDateTime timecreated;

  @Column(name = "timemodified", nullable = false)
  private LocalDateTime timemodified;

  @Column(name = "ici_cctvid", nullable = false)
  private String iciCctvid;
}
