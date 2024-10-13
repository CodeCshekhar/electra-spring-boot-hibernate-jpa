package com.electra.service;


import com.electra.model.PaymentModel;

import java.util.List;

public interface PaymentService {
    PaymentModel savePayment(PaymentModel payment);
    boolean deletePayment(final Long paymentId);
    List<PaymentModel> getAllPayments();
    PaymentModel getPaymentById(final Long paymentId);
}
