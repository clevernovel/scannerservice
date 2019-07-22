package com.umnikov.scannerservice.dao;

import com.umnikov.scannerservice.entity.Item;
import org.springframework.stereotype.Repository;

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
}
