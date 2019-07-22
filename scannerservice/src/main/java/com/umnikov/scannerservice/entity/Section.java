package com.umnikov.scannerservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class Section {
  @Id
  @SequenceGenerator(name = "section_pk_sequence", sequenceName = "section_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "section_pk_sequence")
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
