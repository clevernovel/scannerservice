package com.umnikov.scannerservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
  @Id
  @SequenceGenerator(name = "company_pk_sequence", sequenceName = "company_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_pk_sequence")
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
