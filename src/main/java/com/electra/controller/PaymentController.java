package com.electra.controller;

import com.electra.domain.Payment;
import com.electra.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> retrievePayments() {
        logger.info("Retrieving all payments");
        return ResponseEntity.ok(paymentService.retrievePayments());
    }

    @PostMapping
    public ResponseEntity<Payment> storePayment(@RequestBody Payment payment) {
        logger.info("Storing payment");
        return ResponseEntity.ok(paymentService.storePayment(payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable long id) {
        logger.info("Deleting payment with id: {}", id);
        return ResponseEntity.ok(paymentService.deletePayment(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Payment>> search(@PathVariable long id) {
        logger.info("Searching for payment with id: {}", id);
        return ResponseEntity.ok(paymentService.search(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable long id, @RequestBody Payment payment) {
        logger.info("Updating payment with id: {}", id);
        return ResponseEntity.ok(paymentService.updatePayment(payment));
    }
}
