package com.umnikov.scannerlib.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto extends BaseIdNameDto {
}
