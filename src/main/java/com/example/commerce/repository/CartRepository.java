package com.example.commerce.repository;

import com.example.commerce.domain.Cart;
import com.example.commerce.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByEmailAndItem(String email, Item item);

    Optional<List<Cart>> findAllByEmailOrderByRegisterDateDesc(String email);
}
