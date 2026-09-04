package com.example.travel.controller;

import com.example.travel.repository.HouseRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HomeController}.
 */
@Generated
public class HomeController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'homeController'.
   */
  private static BeanInstanceSupplier<HomeController> getHomeControllerInstanceSupplier() {
    return BeanInstanceSupplier.<HomeController>forConstructor(HouseRepository.class)
            .withGenerator((registeredBean, args) -> new HomeController(args.get(0)));
  }

  /**
   * Get the bean definition for 'homeController'.
   */
  public static BeanDefinition getHomeControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HomeController.class);
    beanDefinition.setInstanceSupplier(getHomeControllerInstanceSupplier());
    return beanDefinition;
  }
}
