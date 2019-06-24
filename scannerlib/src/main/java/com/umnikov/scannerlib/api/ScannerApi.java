package com.umnikov.scannerlib.api;

import com.umnikov.scannerlib.dto.UserDto;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.concurrent.CompletableFuture;

public interface ScannerApi {
  @GET("/scanner/test/{id}")
  CompletableFuture<UserDto> getUserById(@Path("id") Integer id);

  @POST("/scanner/edit")
  CompletableFuture<UserDto> editUser(@Body UserDto user);
}
