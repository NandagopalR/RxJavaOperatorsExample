package com.nanda.rxjavaoperators.model;

/**
 * Created by nandagopal on 2/28/17.
 */
public class Person {

  private String personId;
  private String personName;
  private long mobileNumber;

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
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
