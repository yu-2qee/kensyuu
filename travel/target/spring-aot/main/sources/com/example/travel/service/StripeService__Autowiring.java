package com.example.travel.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link StripeService}.
 */
@Generated
public class StripeService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static StripeService apply(RegisteredBean registeredBean, StripeService instance) {
    AutowiredFieldValueResolver.forRequiredField("stripeApiKey").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
