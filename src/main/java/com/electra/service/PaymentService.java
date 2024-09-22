package com.electra.service;

import com.electra.domain.Payment;
import com.electra.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        logger.info("Payments Retrieved in Services");
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        logger.info("Payment detected by ID in Services");
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment createPayment(Payment payment) {
        logger.info("Payment Created in Services");
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment != null) {
            payment.setAmount(updatedPayment.getAmount());
            payment.setPaymentDate(updatedPayment.getPaymentDate());
            payment.setCustomer(updatedPayment.getCustomer());
            payment.setOrder(updatedPayment.getOrder());
            logger.info("Payment Updated in Services");
            return paymentRepository.save(payment);
        }
        return null;
    }

    public void deletePayment(Long id) {
        logger.info("Payment deleted");
        paymentRepository.deleteById(id);
    }
}
