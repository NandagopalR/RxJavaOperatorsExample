package com.nanda.rxjavaoperators.utils;

import com.nanda.rxjavaoperators.model.Person;
import com.nanda.rxjavaoperators.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandagopal on 2/28/17.
 */
public class CommonUtils {

  public static List<User> getUserList() {

    List<User> userList = new ArrayList<>();

    User userOne = new User();
    userOne.setUserName("Amit");
    userOne.setUserAddress("India");
    userList.add(userOne);

    User userTwo = new User();
    userTwo.setUserName("Manish");
    userTwo.setUserAddress("USA");
    userList.add(userTwo);

    User userThree = new User();
    userThree.setUserName("John");
    userThree.setUserAddress("Australia");
    userList.add(userThree);

    return userList;
  }

  public static List<Person> getPersonList() {

    List<Person> personList = new ArrayList<>();

    Person personOne = new Person();
    personOne.setPersonId(1);
    personOne.setPersonName("Rajiv");
    personOne.setMobileNumber(909143);
    personList.add(personOne);

    Person personTwo = new Person();
    personTwo.setPersonId(2);
    personTwo.setPersonName("Raja");
    personTwo.setMobileNumber(909143421);
    personList.add(personTwo);

    Person personThree = new Person();
    personThree.setPersonId(3);
    personThree.setPersonName("Nanda");
    personThree.setMobileNumber(909143421);
    personList.add(personThree);

    return personList;
  }

  public static List<Person> getAndroidDevList() {

    List<Person> personList = new ArrayList<>();

    Person personPrime = new Person();
    personPrime.setPersonId(4);
    personPrime.setPersonName("Kalpesh");
    personPrime.setMobileNumber(999431432);
    personList.add(personPrime);

    Person personOne = new Person();
    personOne.setPersonId(5);
    personOne.setPersonName("Rajiv");
    personOne.setMobileNumber(995456453);
    personList.add(personOne);

    Person personTwo = new Person();
    personTwo.setPersonId(6);
    personTwo.setPersonName("Raja");
    personTwo.setMobileNumber(999435623);
    personList.add(personTwo);

    Person personThree = new Person();
    personThree.setPersonId(7);
    personThree.setPersonName("Nanda");
    personThree.setMobileNumber(909143421);
    personList.add(personThree);

    return personList;
  }

  public static List<Person> getIPhoneDevList() {

    List<Person> personList = new ArrayList<>();

    Person personOne = new Person();
    personOne.setPersonId(8);
    personOne.setPersonName("Gaurav");
    personOne.setMobileNumber(919239334);
    personList.add(personOne);

    Person personTwo = new Person();
    personTwo.setPersonId(9);
    personTwo.setPersonName("Pavan");
    personTwo.setMobileNumber(742343435);
    personList.add(personTwo);

    return personList;
  }

  public static List<Person> getUiUxDevList() {

    List<Person> personList = new ArrayList<>();

    Person personOne = new Person();
    personOne.setPersonId(10);
    personOne.setPersonName("Sharavanan");
    personOne.setMobileNumber(900923234);
    personList.add(personOne);

    Person personTwo = new Person();
    personTwo.setPersonId(11);
    personTwo.setPersonName("Vignesh");
    personTwo.setMobileNumber(91213243);
    personList.add(personTwo);

    return personList;
  }

  public static List<Person> getBusinessPersonsList() {

    List<Person> personList = new ArrayList<>();

    Person personOne = new Person();
    personOne.setPersonId(12);
    personOne.setPersonName("Prabhu Baggai");
    personOne.setMobileNumber(943434354);
    personList.add(personOne);

    return personList;
  }

  public static List<Person> getMaximoDevList() {

    List<Person> personList = new ArrayList<>();

    Person personOne = new Person();
    personOne.setPersonId(13);
    personOne.setPersonName("Selva");
    personOne.setMobileNumber(943343432);
    personList.add(personOne);

    Person personTwo = new Person();
    personTwo.setPersonId(14);
    personTwo.setPersonName("Shyam");
    personTwo.setMobileNumber(823322431);
    personList.add(personTwo);

    Person personThree = new Person();
    personThree.setPersonId(15);
    personThree.setMobileNumber(932434423);
    personList.add(personThree);

    Person personFour = new Person();
    personFour.setPersonId(16);
    personFour.setMobileNumber(709423243);
    personList.add(personFour);

    return personList;
  }
}
