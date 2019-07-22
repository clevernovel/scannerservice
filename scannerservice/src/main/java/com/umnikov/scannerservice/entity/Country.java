package com.umnikov.scannerservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {
  @Id
  @SequenceGenerator(name = "country_pk_sequence", sequenceName = "country_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_pk_sequence")
  private Long id;
  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
