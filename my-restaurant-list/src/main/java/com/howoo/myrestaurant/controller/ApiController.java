package com.howoo.myrestaurant.controller;


import com.howoo.myrestaurant.service.WishListService;
import com.howoo.myrestaurant.wishlist.dto.WishListDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController{

    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDto search(@RequestParam String query){
        return wishListService.search(query);
    }

    @PostMapping("")
    public WishListDto post(@RequestBody WishListDto wishListDto){
        return wishListService.save(wishListDto);
    }
    @GetMapping("/all")
    public List<WishListDto> findAll(){
        return wishListService.findAll();
    }

    @PostMapping("/{id}")
    public void addVisit(@PathVariable Long id){
        log.info("{}",id);
        wishListService.addVisit(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        log.info("{}",id);
        wishListService.delete(id);
    }
}
