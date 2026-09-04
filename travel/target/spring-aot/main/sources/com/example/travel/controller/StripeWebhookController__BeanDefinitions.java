package com.example.travel.controller;

import com.example.travel.service.StripeService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link StripeWebhookController}.
 */
@Generated
public class StripeWebhookController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'stripeWebhookController'.
   */
  private static BeanInstanceSupplier<StripeWebhookController> getStripeWebhookControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<StripeWebhookController>forConstructor(StripeService.class)
            .withGenerator((registeredBean, args) -> new StripeWebhookController(args.get(0)));
  }

  /**
   * Get the bean definition for 'stripeWebhookController'.
   */
  public static BeanDefinition getStripeWebhookControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(StripeWebhookController.class);
    InstanceSupplier<StripeWebhookController> instanceSupplier = getStripeWebhookControllerInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(StripeWebhookController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
