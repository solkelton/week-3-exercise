package io.training.week3.model;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
    import javax.persistence.FetchType;
    import javax.persistence.GeneratedValue;
    import javax.persistence.Id;
    import javax.persistence.JoinColumn;
    import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
    import javax.persistence.Transient;

@Entity
@Table
public class OrderLineItems {

  @Id
  @GeneratedValue
  private long id;

  @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="productId")
  private Product product;

  private int quantity;
  private double price;
  private double totalPrice;

  @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="shipmentId")
  private Shipment shipment;


  public OrderLineItems() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double price, int quantity) {
    this.totalPrice = price * quantity;
  }

  public Shipment getShipment() {
    return shipment;
  }

  public void setShipment(Shipment shipment) {
    this.shipment = shipment;
  }
}
