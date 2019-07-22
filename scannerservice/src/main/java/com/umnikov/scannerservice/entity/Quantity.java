package com.umnikov.scannerservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "quantity")
public class Quantity {
  @Id
  @SequenceGenerator(name = "quantity_pk_sequence", sequenceName = "quantity_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quantity_pk_sequence")
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
