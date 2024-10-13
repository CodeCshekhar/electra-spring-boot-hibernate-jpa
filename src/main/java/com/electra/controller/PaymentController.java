package com.electra.controller;

import com.electra.model.PaymentModel;
import com.electra.service.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/electra")
public class PaymentController {

    @Resource(name = "paymentService")
    private PaymentService paymentService;

    @GetMapping("/payments")
    public List<PaymentModel> getPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/payment/{id}")
    public PaymentModel getPayment(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/payment")
    public PaymentModel savePayment(final @RequestBody PaymentModel paymentModel){
        return paymentService.savePayment(paymentModel);
    }

    @DeleteMapping("/payment/{id}")
    public Boolean deletePayment(@PathVariable Long id){
        return paymnetService.deletePayment(id);
    }
}