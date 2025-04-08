package com.market.orders_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phone_number;

    private String representive_name;

    private String company_name;

    @OneToMany(mappedBy = "supplier")
    List<Order> orders;

    @ManyToMany(mappedBy = "supplierList")
    List<Product> products;
}
