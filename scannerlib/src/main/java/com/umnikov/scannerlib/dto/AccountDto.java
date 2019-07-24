package com.umnikov.scannerlib.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto {
  public long id;
  public CompanyDto company;
  public CountryDto country;


  public void validation() {
    if (id < 0) {
      throw new RuntimeException();
    }
  }
}
