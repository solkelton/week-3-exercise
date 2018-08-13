package io.training.week3.model.Result;

public class OrderLineItemsResult {

  private String productName;
  private int quantity;

  public OrderLineItemsResult(String productName, int quantity) {
    this.productName = productName;
    this.quantity = quantity;
  }

  public OrderLineItemsResult() {}

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
