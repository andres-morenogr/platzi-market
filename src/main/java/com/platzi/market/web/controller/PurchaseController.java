package com.platzi.market.web.controller;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    private ResponseEntity<List<Purchase>> getAll() {
        return ResponseEntity.ok(purchaseService.getAll());
    }

    @PostMapping("/save")
    private ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.save(purchase));
    }

    @GetMapping("/{clientId}")
    private ResponseEntity<List<Purchase>> getByClientId(@PathVariable String clientId) {
        return purchaseService.getByClient(clientId).map(purchases -> ResponseEntity.ok(purchases))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
