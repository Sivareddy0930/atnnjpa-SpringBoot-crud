package com.Allpackages.OrdersRepo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Allpackages.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Serializable> {

}
