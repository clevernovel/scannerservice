package com.umnikov.scannerservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
  @Id
  @SequenceGenerator(name = "account_pk_sequence", sequenceName = "account_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_pk_sequence")
  private Long id;
  private Long company;
  private Long country;

  public Long getId() {
    return id;
  }

  public Long getCompany() {
    return company;
  }

  public void setCompany(Long company) {
    this.company = company;
  }

  public Long getCountry() {
    return country;
  }

  public void setCountry(Long country) {
    this.country = country;
  }
}
