package com.example.travel.controller;

import com.example.travel.repository.UserRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AdminUserController}.
 */
@Generated
public class AdminUserController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'adminUserController'.
   */
  private static BeanInstanceSupplier<AdminUserController> getAdminUserControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AdminUserController>forConstructor(UserRepository.class)
            .withGenerator((registeredBean, args) -> new AdminUserController(args.get(0)));
  }

  /**
   * Get the bean definition for 'adminUserController'.
   */
  public static BeanDefinition getAdminUserControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AdminUserController.class);
    beanDefinition.setInstanceSupplier(getAdminUserControllerInstanceSupplier());
    return beanDefinition;
  }
}
