package com.example.travel.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link StripeService}.
 */
@Generated
public class StripeService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'stripeService'.
   */
  private static BeanInstanceSupplier<StripeService> getStripeServiceInstanceSupplier() {
    return BeanInstanceSupplier.<StripeService>forConstructor(ReservationService.class)
            .withGenerator((registeredBean, args) -> new StripeService(args.get(0)));
  }

  /**
   * Get the bean definition for 'stripeService'.
   */
  public static BeanDefinition getStripeServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(StripeService.class);
    InstanceSupplier<StripeService> instanceSupplier = getStripeServiceInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(StripeService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
