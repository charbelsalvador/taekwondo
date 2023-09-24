package com.taekwondo.Taekwondo.controller;

import com.taekwondo.Taekwondo.models.CustomerTaekwondo;
import com.taekwondo.Taekwondo.models.ProductsTaekwondo;
import com.taekwondo.Taekwondo.service.CustomerService;
import com.taekwondo.Taekwondo.service.TaekwondoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products-taekwondo/v1/")
public class TaekowndoController {

    private final TaekwondoService taekwondoService;
    private final CustomerService customerService;

    public TaekowndoController(TaekwondoService taekwondoService, CustomerService customerService) {
        this.taekwondoService = taekwondoService;
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductsTaekwondo>create(@RequestBody ProductsTaekwondo productsTaekwondo){
        ProductsTaekwondo productsTaekwondoSaved = this.taekwondoService.saved(productsTaekwondo);
        return ResponseEntity.ok(productsTaekwondoSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsTaekwondo>findById(@PathVariable Long id){
        Optional<ProductsTaekwondo>productsTaekwondoFindById = this.taekwondoService.findById(id);
        if (productsTaekwondoFindById.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productsTaekwondoFindById.get());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductsTaekwondo>>findAll(ProductsTaekwondo productsTaekwondo){
        List<ProductsTaekwondo>productsTaekwondoFindAll = this.taekwondoService.findAll();
        return ResponseEntity.ok(productsTaekwondoFindAll);
    }

    @PutMapping("update-version/{id}")
    public ResponseEntity<ProductsTaekwondo>updateVersion(@RequestParam("version") String version,
                                                          @PathVariable Long id){
        Optional<ProductsTaekwondo>productsTaekwondoUpdateVersion = this.taekwondoService.updateVersion(version, id);

        if (productsTaekwondoUpdateVersion.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productsTaekwondoUpdateVersion.get());
    }

    @PutMapping("update-name/{id}")
    public ResponseEntity<ProductsTaekwondo>updateName(@RequestParam("name")String name,
                                                       @PathVariable Long id){
        Optional<ProductsTaekwondo>productsTaekwondoUpdateName = this.taekwondoService.updateName(name, id);

        if (productsTaekwondoUpdateName.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productsTaekwondoUpdateName.get());
    }
    @PutMapping("update-creator/{id}")
    public ResponseEntity<ProductsTaekwondo>updateCreator(@RequestParam("creator")String creator,
                                                          @PathVariable Long id){
        Optional<ProductsTaekwondo>productsTaekwondoUpdateCreator = this.taekwondoService.updateCreator(creator, id);

        if (productsTaekwondoUpdateCreator.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productsTaekwondoUpdateCreator.get());
    }

    //Customers

    @PostMapping("/create-customer")
    public ResponseEntity<CustomerTaekwondo>createCustomer(@RequestParam("name")String name,
                                                           @RequestParam("productId")Long productId){
        ProductsTaekwondo productsTaekwondo = this.taekwondoService.findById(productId).get();
        CustomerTaekwondo customerTaekwondo = this.customerService.create(name,productsTaekwondo);
        return ResponseEntity.ok(customerTaekwondo);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerTaekwondo>customerFindById(@PathVariable Long id){
        Optional<CustomerTaekwondo>customerFindById = this.customerService.findById(id);
        if (customerFindById.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customerFindById.get());
    }

    @GetMapping("/all-customer")
    public ResponseEntity<List<CustomerTaekwondo>>customerAll(CustomerTaekwondo customerTaekwondo){
        List<CustomerTaekwondo>customerTaekwondoAll = this.customerService.findAll();
        return ResponseEntity.ok(customerTaekwondoAll);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteCustomer(@PathVariable Long id){
        this.customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update-customer/{id}")
    public ResponseEntity<CustomerTaekwondo>customerUpdateName(@PathVariable Long id,
                                                               @RequestParam("name")String name,
                                                               @RequestParam("productId")Long productId){
        ProductsTaekwondo productsTaekwondo = this.taekwondoService.findById(productId).orElse(null);
        if (productsTaekwondo==null){
            return ResponseEntity.badRequest().build();
        }
        Optional<CustomerTaekwondo>customerUpdateName = this.customerService.updateName(id, name, productsTaekwondo);
        if (customerUpdateName.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customerUpdateName.get());
    }
}
