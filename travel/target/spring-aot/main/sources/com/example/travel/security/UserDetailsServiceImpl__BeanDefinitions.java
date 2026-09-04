package com.example.travel.security;

import com.example.travel.repository.UserRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserDetailsServiceImpl}.
 */
@Generated
public class UserDetailsServiceImpl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userDetailsServiceImpl'.
   */
  private static BeanInstanceSupplier<UserDetailsServiceImpl> getUserDetailsServiceImplInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<UserDetailsServiceImpl>forConstructor(UserRepository.class)
            .withGenerator((registeredBean, args) -> new UserDetailsServiceImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'userDetailsServiceImpl'.
   */
  public static BeanDefinition getUserDetailsServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserDetailsServiceImpl.class);
    beanDefinition.setInstanceSupplier(getUserDetailsServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
