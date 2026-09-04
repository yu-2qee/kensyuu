package com.example.travel.service;

import com.example.travel.repository.VerificationTokenRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VerificationTokenService}.
 */
@Generated
public class VerificationTokenService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'verificationTokenService'.
   */
  private static BeanInstanceSupplier<VerificationTokenService> getVerificationTokenServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<VerificationTokenService>forConstructor(VerificationTokenRepository.class)
            .withGenerator((registeredBean, args) -> new VerificationTokenService(args.get(0)));
  }

  /**
   * Get the bean definition for 'verificationTokenService'.
   */
  public static BeanDefinition getVerificationTokenServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VerificationTokenService.class);
    beanDefinition.setInstanceSupplier(getVerificationTokenServiceInstanceSupplier());
    return beanDefinition;
  }
}
