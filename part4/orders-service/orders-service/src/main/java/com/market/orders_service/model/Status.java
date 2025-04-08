package com.market.orders_service.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "statuses")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status_desc")
    private String statusDesc;

    @OneToMany(mappedBy = "status")
    List<Order> orders;
}
