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
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location")
  private Location location;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "quantity")
  private Quantity quantity;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "account")
  private Account account;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "section")
  private Section section;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "equipment")
  private Equipment equipment;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "material")
  private Material material;
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

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Quantity getQuantity() {
    return quantity;
  }

  public void setQuantity(Quantity quantity) {
    this.quantity = quantity;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Section getSection() {
    return section;
  }

  public void setSection(Section section) {
    this.section = section;
  }

  public Equipment getEquipment() {
    return equipment;
  }

  public void setEquipment(Equipment equipment) {
    this.equipment = equipment;
  }

  public Material getMaterial() {
    return material;
  }

  public void setMaterial(Material material) {
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
