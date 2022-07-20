package com.be.ecommerce.repositories;

import com.be.ecommerce.entities.Shipper;
import com.be.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper,Long> {

    Optional<Shipper> findShipperByPhone(String phone);
}
