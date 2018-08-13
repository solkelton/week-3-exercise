package io.training.week3.model;


import io.training.week3.model.results.OrdersDisplay;
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
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table
@SqlResultSetMapping(
    name="accountOrdersMapping",
    classes = @ConstructorResult(
        targetClass = OrdersDisplay.class,
        columns = {
            @ColumnResult(name = "order_date", type = Timestamp.class),
            @ColumnResult(name = "order_number", type = BigInteger.class),
            @ColumnResult(name = "total_price", type = Double.class)}))
@NamedNativeQuery(
    name="retrieveAccountOrders",
    query="SELECT order_date, order_number, total_price from orders where account_id = ?1 group by order_number order by order_date asc",
    resultSetMapping = "accountOrdersMapping"
)
public class Account {
  @Id
  @GeneratedValue
  private long id;

  private String firstName;
  private String lastName;
  private String emailAddress;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="accountId")
  private List<Address> addressList;

  public Account(String firstName, String lastName, String emailAddress, List<Address> addressList) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
    this.addressList = addressList;
  }

  public Account() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public List<Address> getAddressList() {
    return addressList;
  }

  public void setAddressList(List<Address> addressList) {
    this.addressList = addressList;
  }
}
