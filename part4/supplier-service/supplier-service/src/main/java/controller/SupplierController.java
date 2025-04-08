package controller;

import model.Product;
import model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("api/suppliers")
public class SupplierController {
    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService){
        this.supplierService=supplierService;
    }

    @GetMapping()
    public ResponseEntity<List<Supplier>> getAllSuppliers(){
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getSupplierProducts(@PathVariable Integer supplierId){
        return ResponseEntity.ok(supplierService.getSupplierProducts(supplierId));
    }
}