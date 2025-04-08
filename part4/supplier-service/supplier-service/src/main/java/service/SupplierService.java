package service;

import model.Product;
import model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }
    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public List<Product> getSupplierProducts(Integer supplierId){
        Optional<Supplier> supplier=supplierRepository.findById(supplierId);
        if(supplier==null)//TODO check if .get() is needed here
            throw new RuntimeException("לא נמצא ספק!");
        return supplier.get().getProducts();
    }


}
