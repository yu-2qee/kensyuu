package com.example.travel.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.travel.service.StripeService;
import com.stripe.exception.EventDataObjectDeserializationException;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.net.Webhook;

@RestController
public class StripeWebhookController {

    // application.properties に stripe.webhook-secret=whsec_xxxxx を設定してください
    // (ローカルの場合は `stripe listen --forward-to localhost:8080/stripe/webhook` 実行時に表示される値)
    @Value("${stripe.webhook-secret}")
    private String webhookSecret;

    private final StripeService stripeService;

    public StripeWebhookController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/stripe/webhook")
    public String webhook(@RequestBody String payload,
                           @RequestHeader("Stripe-Signature") String sigHeader) throws EventDataObjectDeserializationException {

        System.out.println("=== /stripe/webhook にリクエストが届きました");

        Event event;

        try {
            event = Webhook.constructEvent(payload, sigHeader, webhookSecret);
        } catch (SignatureVerificationException e) {
            System.out.println("=== 署名検証に失敗しました");
            e.printStackTrace();
            return "";
        }

        System.out.println("=== event.getType(): [" + event.getType() + "]");

        if ("checkout.session.completed".equals(event.getType())) {
            System.out.println("=== checkout.session.completed に一致。processSessionCompletedを呼びます");
            stripeService.processSessionCompleted(event);
        } else {
            System.out.println("=== イベントタイプが一致しないためスキップされました");
        }

        return "";
    }
}



//
//package com.example.samuraitravel1.controller;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//import com.example.samuraitravel1.service.StripeService;
//import com.stripe.Stripe;
//import com.stripe.exception.SignatureVerificationException;
//import com.stripe.model.Event;
//import com.stripe.net.Webhook;
//
//
//@Controller
//
//public class StripeWebhookController {
//
//private final StripeService stripeService;
//
//
//@Value("${stripe.api-key}")
//
//private String stripeApiKey;
//
//
//@Value("${stripe.webhook-secret}")
//
//private String webhookSecret;
//
//
//public StripeWebhookController(StripeService stripeService) {
//
//this.stripeService = stripeService;
//
//}
//
//
//@PostMapping("/stripe/webhook")
//
//public ResponseEntity<String> webhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) {
//
//Stripe.apiKey = stripeApiKey;
//
//Event event = null;
//
//
//try {
//
//event = Webhook.constructEvent(payload, sigHeader, webhookSecret);
//
//} catch (SignatureVerificationException e) {
//
//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//
//}
//
//
//if ("checkout.session.completed".equals(event.getType())) {
//
//stripeService.processSessionCompleted(event);
//
//}
//
//
//return new ResponseEntity<>("Success", HttpStatus.OK);
//
//}
//
//}