package io.training.week3;

import io.training.week3.model.Account;
import io.training.week3.model.Address;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommerceDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CommerceDemoApplication.class, args);

  }
}
