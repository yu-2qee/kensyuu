package com.example.travel.controller;

import com.example.travel.repository.HouseRepository;
import com.example.travel.repository.ReservationRepository;
import com.example.travel.service.ReservationService;
import com.example.travel.service.StripeService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReservationController}.
 */
@Generated
public class ReservationController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'reservationController'.
   */
  private static BeanInstanceSupplier<ReservationController> getReservationControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReservationController>forConstructor(ReservationRepository.class, HouseRepository.class, ReservationService.class, StripeService.class)
            .withGenerator((registeredBean, args) -> new ReservationController(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'reservationController'.
   */
  public static BeanDefinition getReservationControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReservationController.class);
    beanDefinition.setInstanceSupplier(getReservationControllerInstanceSupplier());
    return beanDefinition;
  }
}
