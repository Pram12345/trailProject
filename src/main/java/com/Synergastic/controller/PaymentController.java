package com.Synergastic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.Synergastic.Repository.PaymentRepository;
import com.Synergastic.model.Payment;


@Controller
//@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/payment")
    public String home() {
        return "payment"; // Thymeleaf template for the payment page
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook(@RequestBody WebhookRequest request) {
        try {
            Payment payment = new Payment();
            payment.setRazorpayPaymentId(request.getPaymentId());
            payment.setAmount(request.getAmount());
            payment.setCurrency(request.getCurrency());
            payment.setDescription(request.getDescription());

            paymentRepository.save(payment);

            return ResponseEntity.ok("Payment data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error processing payment data: " + e.getMessage());
        }
    }
}
