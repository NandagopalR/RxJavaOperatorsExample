package com.nanda.rxjavaoperators.model;

/**
 * Created by nandagopal on 2/28/17.
 */
public class User {

  private String userId;
  private String userName;
  private String userAddress;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }
}
