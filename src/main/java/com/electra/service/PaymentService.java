package com.electra.service;

import com.electra.domain.Payment;
import com.electra.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository repo;

    public List<Payment> retrievePayments() {
        logger.info("Inside PaymentService.retrievePayments()");
        return repo.findAll();
    }

    public Payment storePayment(Payment payment) {
        logger.info("Inside PaymentService.storePayment()");
        return repo.save(payment);
    }

    public String deletePayment(long id) {
        logger.info("Inside PaymentService.deletePayment()");
        repo.deleteById(id);
        return "Payment Deleted";
    }

    public Optional<Payment> search(long id) {
        logger.info("Inside PaymentService.search()");
        return repo.findById(id);
    }

    public Payment updatePayment(Payment payment) {
        logger.info("Inside PaymentService.updatePayment()");
        return repo.save(payment);
    }
}
