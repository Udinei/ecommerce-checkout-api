package com.udinei.dio.ecommerce.checkout.api.repository;

import com.udinei.dio.ecommerce.checkout.api.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {

}
