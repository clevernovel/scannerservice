package com.umnikov.scannerservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
  @Id
  @SequenceGenerator(name = "item_pk_sequence", sequenceName = "item_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_pk_sequence")
  private Long id;
  private String name;
  private Long location;
  private Long quantity;
  private Long account;
  private Long section;
  private Long equipment;
  private Long material;
  private String global;
  private String comment;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getLocation() {
    return location;
  }

  public void setLocation(Long location) {
    this.location = location;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public Long getAccount() {
    return account;
  }

  public void setAccount(Long account) {
    this.account = account;
  }

  public Long getSection() {
    return section;
  }

  public void setSection(Long section) {
    this.section = section;
  }

  public Long getEquipment() {
    return equipment;
  }

  public void setEquipment(Long equipment) {
    this.equipment = equipment;
  }

  public Long getMaterial() {
    return material;
  }

  public void setMaterial(Long material) {
    this.material = material;
  }

  public String getGlobal() {
    return global;
  }

  public void setGlobal(String global) {
    this.global = global;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
