package com.example.travel.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link StripeWebhookController}.
 */
@Generated
public class StripeWebhookController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static StripeWebhookController apply(RegisteredBean registeredBean,
      StripeWebhookController instance) {
    AutowiredFieldValueResolver.forRequiredField("webhookSecret").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
