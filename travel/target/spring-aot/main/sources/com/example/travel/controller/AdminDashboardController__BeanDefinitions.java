package com.example.travel.controller;

import com.example.travel.repository.AdminDashboardRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AdminDashboardController}.
 */
@Generated
public class AdminDashboardController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'adminDashboardController'.
   */
  private static BeanInstanceSupplier<AdminDashboardController> getAdminDashboardControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AdminDashboardController>forConstructor(AdminDashboardRepository.class)
            .withGenerator((registeredBean, args) -> new AdminDashboardController(args.get(0)));
  }

  /**
   * Get the bean definition for 'adminDashboardController'.
   */
  public static BeanDefinition getAdminDashboardControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AdminDashboardController.class);
    beanDefinition.setInstanceSupplier(getAdminDashboardControllerInstanceSupplier());
    return beanDefinition;
  }
}
