package com.example.travel.controller;

import com.example.travel.repository.HouseRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HouseController}.
 */
@Generated
public class HouseController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'houseController'.
   */
  private static BeanInstanceSupplier<HouseController> getHouseControllerInstanceSupplier() {
    return BeanInstanceSupplier.<HouseController>forConstructor(HouseRepository.class)
            .withGenerator((registeredBean, args) -> new HouseController(args.get(0)));
  }

  /**
   * Get the bean definition for 'houseController'.
   */
  public static BeanDefinition getHouseControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HouseController.class);
    beanDefinition.setInstanceSupplier(getHouseControllerInstanceSupplier());
    return beanDefinition;
  }
}
