package com.example.travel.service;

import com.example.travel.repository.HouseRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HouseService}.
 */
@Generated
public class HouseService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'houseService'.
   */
  private static BeanInstanceSupplier<HouseService> getHouseServiceInstanceSupplier() {
    return BeanInstanceSupplier.<HouseService>forConstructor(HouseRepository.class)
            .withGenerator((registeredBean, args) -> new HouseService(args.get(0)));
  }

  /**
   * Get the bean definition for 'houseService'.
   */
  public static BeanDefinition getHouseServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HouseService.class);
    beanDefinition.setInstanceSupplier(getHouseServiceInstanceSupplier());
    return beanDefinition;
  }
}
