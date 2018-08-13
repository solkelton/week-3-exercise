package io.training.week3.model;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Shipment {

  @Id
  @GeneratedValue
  private long id;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="accountId")
  private Account account;

  @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="shippingId")
  private Address shippingAddress;

  @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="orderLineItemsId")
  private List<OrderLineItems> orderLineItems;

  private Timestamp shippedDate;
  private Timestamp deliveryDate;

  public Shipment() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Address getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public List<OrderLineItems> getOrderLineItems() {
    return orderLineItems;
  }

  public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
    this.orderLineItems = orderLineItems;
  }

  public Timestamp getShippedDate() {
    return shippedDate;
  }

  public void setShippedDate(Timestamp shippedDate) {
    this.shippedDate = shippedDate;
  }

  public Timestamp getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Timestamp deliveryDate) {
    this.deliveryDate = deliveryDate;
  }
}
