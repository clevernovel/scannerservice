package com.umnikov.scannerservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
  @Id
  @SequenceGenerator(name = "account_pk_sequence", sequenceName = "account_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_pk_sequence")
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company")
  private Company company;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "country")
  private Country country;

  public Long getId() {
    return id;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }
}
