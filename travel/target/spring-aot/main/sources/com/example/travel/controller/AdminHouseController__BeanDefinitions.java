package com.example.travel.controller;

import com.example.travel.repository.HouseRepository;
import com.example.travel.service.HouseService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AdminHouseController}.
 */
@Generated
public class AdminHouseController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'adminHouseController'.
   */
  private static BeanInstanceSupplier<AdminHouseController> getAdminHouseControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AdminHouseController>forConstructor(HouseRepository.class, HouseService.class)
            .withGenerator((registeredBean, args) -> new AdminHouseController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'adminHouseController'.
   */
  public static BeanDefinition getAdminHouseControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AdminHouseController.class);
    beanDefinition.setInstanceSupplier(getAdminHouseControllerInstanceSupplier());
    return beanDefinition;
  }
}
