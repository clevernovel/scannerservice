package com.umnikov.scannerservice.controller;

import com.umnikov.scannerlib.dto.ItemDto;
import com.umnikov.scannerservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemMessageController {
  private final ItemService itemService;

  @Autowired
  public ItemMessageController(ItemService itemService) {
    this.itemService = itemService;
  }

  @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
  public ItemDto getItemById(@PathVariable Long id) {
    return itemService.getItemById(id);
  }

    @RequestMapping(value = "/test/save", method = RequestMethod.POST)
  public ItemDto saveNewElement(@RequestBody ItemDto request) {
    return itemService.create(request);
  }

  @RequestMapping(value = "/test/all/{id}", method = RequestMethod.GET)
  public List getItemsByMultipleIds(@PathVariable List<Long> id) {
    return itemService.getItemsByMultipleIds(id);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public ItemDto editUser(@RequestBody ItemDto request) {
    return itemService.editItem(request);
  }
}

