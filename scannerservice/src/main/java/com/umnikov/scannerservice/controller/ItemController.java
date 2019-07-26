package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.ItemDto;
import com.umnikov.scannerservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
  private final ItemService itemService;

  @Autowired
  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @RequestMapping(value = "/by_id/{id}", method = RequestMethod.GET)
  public ItemDto byId(@PathVariable Long id) {
    return itemService.byId(id);
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public ItemDto save(@RequestBody ItemDto request) {
    return itemService.save(request);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List all() {
    return itemService.all();
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public ItemDto edit(@RequestBody ItemDto request) {
    return itemService.edit(request);
  }
}

