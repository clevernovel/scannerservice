package com.umnikov.scannerservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
  @Id
  @SequenceGenerator(name = "users_pk_sequence", sequenceName = "users_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_pk_sequence")
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
