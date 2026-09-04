package com.example.travel.service;

import com.example.travel.repository.HouseRepository;
import com.example.travel.repository.ReservationRepository;
import com.example.travel.repository.UserRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReservationService}.
 */
@Generated
public class ReservationService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'reservationService'.
   */
  private static BeanInstanceSupplier<ReservationService> getReservationServiceInstanceSupplier() {
    return BeanInstanceSupplier.<ReservationService>forConstructor(ReservationRepository.class, HouseRepository.class, UserRepository.class)
            .withGenerator((registeredBean, args) -> new ReservationService(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'reservationService'.
   */
  public static BeanDefinition getReservationServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReservationService.class);
    beanDefinition.setInstanceSupplier(getReservationServiceInstanceSupplier());
    return beanDefinition;
  }
}
