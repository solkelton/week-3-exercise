package io.training.week3.model;

import io.training.week3.model.Result.AddressResult;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table
@SqlResultSetMapping(
    name="orderAddressMapping",
    classes = @ConstructorResult(
        targetClass = AddressResult.class,
        columns = {
            @ColumnResult(name = "street", type = String.class),
            @ColumnResult(name = "building", type = String.class),
            @ColumnResult(name = "city", type = String.class),
            @ColumnResult(name = "state", type = String.class),
            @ColumnResult(name = "zip", type = String.class),
            @ColumnResult(name = "country", type = String.class)}))
@NamedNativeQuery(
    name="retrieveShippingAddress",
    query="select street, building, city, state, zip, country from address where id = "
        + "(select  shipping_id from orders where account_id = ?1 and id = ?2)",
    resultSetMapping = "orderAddressMapping"
)
public class Address {

  @Id
  @GeneratedValue
  private long id;
  private String street;
  private String building;
  private String city;
  private String state;
  private String zip;
  private String country;

  public Address() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public String getCity() { return city; }

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
