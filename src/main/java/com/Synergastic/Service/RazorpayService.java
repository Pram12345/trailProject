package com.Synergastic.Service;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;




@Service
public class RazorpayService {

    @Value("${razorpay.key_id}")
    private String keyId;

    @Value("${razorpay.key_secret}")
    private String keySecret;

    public Order createOrder(String amount) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(keyId, keySecret);

        JSONObject options = new JSONObject();
        options.put("amount", Integer.parseInt(amount) * 100); // amount in paise
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");

        return razorpay.orders.create(options);
    }
}
