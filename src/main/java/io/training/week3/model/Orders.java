package io.training.week3.model;

import io.training.week3.model.results.OrderDetails;
import java.math.BigInteger;
import java.sql.Timestamp;
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
    name="orderDisplayMapping",
    classes = @ConstructorResult(
        targetClass = OrderDetails.class,
        columns = {
            @ColumnResult(name = "orderNumber", type = BigInteger.class),
            @ColumnResult(name = "totalPrice", type = Double.class),
            @ColumnResult(name = "street", type = String.class),
            @ColumnResult(name = "building", type = String.class),
            @ColumnResult(name = "city", type = String.class),
            @ColumnResult(name = "state", type = String.class),
            @ColumnResult(name = "zip", type = String.class),
            @ColumnResult(name = "country", type = String.class),
            @ColumnResult(name = "productName", type = String.class),
        }))
@NamedNativeQuery(
    name="retrieveOrderDetails",
    query="select q1.order_number as orderNumber, q1.total_price as totalPrice, "
        + "q2.street, q2.building, q2.city, q2.state, q2.zip, q2.country, q3.name as productName "
        + "from orders q1, address q2, product q3 "
        + "where q1.account_id = ?1 and "
        + "q2.id in (select shipping_id from orders where account_id = ?1) and "
        + "q3.id in (select product_id from order_line_items where order_line_items_id in (select id from orders where account_id = ?1)) "
        + "group by orderNumber",
    resultSetMapping = "orderDisplayMapping"
)
public class Orders {

  @Id
  @GeneratedValue
  private long id;

  @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="accountId")
  private Account account;

  private long orderNumber;
  private Timestamp orderDate;

  @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="shippingId")
  private Address shippingAddress;

  @OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="orderLineItemsId")
  private List<OrderLineItems> orderLineItems;

  private double totalPrice;

  public Orders() {}

  public long getId() { return id; }

  public void setId(long id) {
    this.id = id;
  }

  public long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Timestamp getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Timestamp orderDate) {
    this.orderDate = orderDate;
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

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }
}
