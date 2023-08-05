package com.example.commerce.repository;

import com.example.commerce.domain.Cart;
import com.example.commerce.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByCustomerNoAndItem(Long customerNo, Item item);

    Optional<List<Cart>> findAllByCustomerNoOrderByRegisterDateDesc(Long customerNo);


}
