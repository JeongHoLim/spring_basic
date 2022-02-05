package com.howoo.myrestaurant.wishlist.repository;

import com.howoo.myrestaurant.wishlist.entity.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishListEntity,Long> {

//    WishListEntity findById(Long id);
    Optional<WishListEntity> findById(Long id);
    List<WishListEntity> findAll();
    void delete(WishListEntity entity);
    WishListEntity save(WishListEntity entity);

    Optional<WishListEntity> findByTitle(String title);
}
