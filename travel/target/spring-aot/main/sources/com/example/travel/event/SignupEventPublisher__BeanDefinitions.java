package com.example.travel.event;

import com.example.travel.Application;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationEventPublisher;

/**
 * Bean definitions for {@link SignupEventPublisher}.
 */
@Generated
public class SignupEventPublisher__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'signupEventPublisher'.
   */
  private static BeanInstanceSupplier<SignupEventPublisher> getSignupEventPublisherInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SignupEventPublisher>forConstructor(ApplicationEventPublisher.class, Application.class)
            .withGenerator((registeredBean, args) -> new SignupEventPublisher(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'signupEventPublisher'.
   */
  public static BeanDefinition getSignupEventPublisherBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SignupEventPublisher.class);
    beanDefinition.setInstanceSupplier(getSignupEventPublisherInstanceSupplier());
    return beanDefinition;
  }
}
