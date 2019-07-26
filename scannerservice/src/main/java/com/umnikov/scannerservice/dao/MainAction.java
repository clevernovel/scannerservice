package com.umnikov.scannerservice.dao;

import java.util.List;

public interface MainAction<T> {
  T byId(Long id);

  T saveAndFlush(T model);

  List<T> all();
}
