package com.example.travel.event;

import com.example.travel.service.VerificationTokenService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Bean definitions for {@link SignupEventListener}.
 */
@Generated
public class SignupEventListener__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'signupEventListener'.
   */
  private static BeanInstanceSupplier<SignupEventListener> getSignupEventListenerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SignupEventListener>forConstructor(VerificationTokenService.class, JavaMailSender.class)
            .withGenerator((registeredBean, args) -> new SignupEventListener(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'signupEventListener'.
   */
  public static BeanDefinition getSignupEventListenerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SignupEventListener.class);
    beanDefinition.setInstanceSupplier(getSignupEventListenerInstanceSupplier());
    return beanDefinition;
  }
}
