package model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private int min_required_qty_in_store;
    @ManyToMany
    @JoinTable(name="supplier_products",
            joinColumns=@JoinColumn(name="supplier_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    private List<Supplier> supplierList;


}
