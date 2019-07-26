package com.umnikov.scannerservice.services;

import com.umnikov.scannerservice.dao.MainAction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(transactionManager = "transactionManager")
public abstract class ServiceForController<T, F> {
  protected MainAction<F> dao;

  public ServiceForController(MainAction<F> dao) {
    this.dao = dao;
  }

  public abstract T convertToDto(F model);

  public abstract F convertToModel(T dto);

  public abstract T edit(T dto);

  public List<T> all() {
    List<F> models = dao.all();
    return models.stream().map(this::convertToDto).collect(Collectors.toList());
  }

  public T byId(Long id) {
    F model = dao.byId(id);
    return convertToDto(model);
  }

  public T save(T dto) {
    F result = dao.saveAndFlush(convertToModel(dto));
    return convertToDto(result);
  }
}
