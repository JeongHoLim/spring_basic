package com.howoo.myrestaurant.wishlist.entity;


import com.howoo.myrestaurant.wishlist.repository.WishListRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WishListEntityTest {

    @Autowired
    private WishListRepository repository;

    @Test
    void crud(){

        repository.findAll().forEach(System.out::println);

    }
}