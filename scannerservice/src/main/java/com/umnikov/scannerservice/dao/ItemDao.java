package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao extends Dao<Item> {
  public ItemDao() {
    super(Item.class);
  }

  public Item saveAndFlush(Item item) {
    super.save(item);
    super.flush();
    return item;
  }

  @Override
  public List<Item> all() {
    return getAll();
  }
}
