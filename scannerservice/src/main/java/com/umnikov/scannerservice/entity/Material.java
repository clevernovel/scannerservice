package com.umnikov.scannerservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "material")
public class Material {
  @Id
  @SequenceGenerator(name = "material_pk_sequence", sequenceName = "material_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_pk_sequence")
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
