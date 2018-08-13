package io.training.week3.model.results;

import java.math.BigInteger;

public class OrderDetails {

  private BigInteger orderNumber;
  private Double totalPrice;
  private String street;
  private String building;
  private String city;
  private String state;
  private String zip;
  private String country;
  private String productName;

  public OrderDetails() {}

  public OrderDetails(BigInteger orderNumber, Double totalPrice, String street, String building,
      String city, String state, String zip, String country, String productName) {
    this.orderNumber = orderNumber;
    this.totalPrice = totalPrice;
    this.street = street;
    this.building = building;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.country = country;
    this.productName = productName;
  }

  public BigInteger getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(BigInteger orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getBuilding() {
    return building;
  }

  public void setBuilding(String building) {
    this.building = building;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
