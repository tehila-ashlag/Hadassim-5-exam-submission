package com.market.orders_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private java.time.LocalDateTime orderDate;

  @ManyToOne
  @JoinColumn(name = "status_id")
  private Status status;

  @ManyToOne
  @JoinColumn(name="supplier_id")
  private Supplier supplier;

  @ManyToMany(mappedBy = "orderList")
  private List<Product> productList;

}