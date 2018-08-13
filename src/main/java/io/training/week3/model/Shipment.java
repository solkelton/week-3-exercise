package io.training.week3.model;

import io.training.week3.model.results.ShipmentDetails;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table
@SqlResultSetMapping(
    name="accountShipmentMapping",
    classes = @ConstructorResult(
        targetClass = ShipmentDetails.class,
        columns = {
            @ColumnResult(name = "orderNumber", type = BigInteger.class),
            @ColumnResult(name = "shipmentDate", type = Date.class),
            @ColumnResult(name = "deliveryDate", type = Date.class),
            @ColumnResult(name = "productName", type = String.class),
            @ColumnResult(name = "quantity", type = Integer.class)}))
@NamedNativeQuery(
    name="retrieveShipmentDetails",
    query="select distinct q1.order_number as orderNumber, date(q2.shipped_date) as shipmentDate, "
        + "date(q2.delivery_date) as deliveryDate,q3.name as productName, q4.quantity as quantity "
        + "from orders q1, shipment q2, product q3, order_line_items q4 "
        + "where q1.account_id = ?1 and "
        + "q2.id in (select shipment_id from order_line_items where order_line_items_id in (select id from orders where account_id = ?1)) and "
        + "q3.id in (select product_id from order_line_items where order_line_items_id in (select id from orders where account_id = ?1)) and "
        + "q4.order_line_items_id in (select id from orders where account_id = ?1) group by orderNumber",
    resultSetMapping = "accountShipmentMapping"
)
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
