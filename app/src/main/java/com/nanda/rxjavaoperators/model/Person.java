package com.nanda.rxjavaoperators.model;

/**
 * Created by nandagopal on 2/28/17.
 */
public class Person {

  private int personId;
  private String personName;
  private long mobileNumber;

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public String getPersonName() {
    return personName;
  }

  public void setPersonName(String personName) {
    this.personName = personName;
  }

  public long getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(long mobileNumber) {
    this.mobileNumber = mobileNumber;
  }
}
