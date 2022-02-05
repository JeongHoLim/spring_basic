package com.howoo.myrestaurant.service;

import com.howoo.myrestaurant.naver.Naver;
import com.howoo.myrestaurant.naver.dto.SearchImageReq;
import com.howoo.myrestaurant.naver.dto.SearchLocalReq;
import com.howoo.myrestaurant.wishlist.dto.WishListDto;
import com.howoo.myrestaurant.wishlist.entity.WishListEntity;
import com.howoo.myrestaurant.wishlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class WishListService {

    private final Naver naver;
    private final WishListRepository repository;

    public WishListDto search(String query) {
        SearchLocalReq localReq = new SearchLocalReq();
        localReq.setQuery(query);

        var localResponse = naver.searchLocal(localReq);

        if(localResponse.getTotal()>0){
            var localItem = localResponse.getItems().stream().findFirst().get();
            var searchImageReq = new SearchImageReq();
            var imageQuery = localItem.getTitle();
            searchImageReq.setQuery(imageQuery);

            var imageResponse = naver.searchImage(searchImageReq);
            if(imageResponse.getTotal()>0){

                var imageItem = imageResponse.getItems().stream().findFirst().get();
                var result = new WishListDto();
                var refinedTitle =localItem.getTitle().replaceAll("<[^>]*>", "") ;
//                var id = repository.findByTitle(refinedTitle).orElse()getId();
                var found = repository.findByTitle(refinedTitle);
                if(found.isPresent()){
                    result.setId(found.get().getId());
                }
                result.setTitle(refinedTitle);
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setHomePageLink(localItem.getLink());
                result.setRoadAddress(localItem.getRoadAddress());
                result.setImageLink(imageItem.getLink());

                return result;
            }
        }

        return new WishListDto();
    }

    private WishListDto entityToDto(WishListEntity entity) {

        var dto = new WishListDto();

        dto.setVisitCount(entity.getVisitCount());
        dto.setVisit(entity.isVisit());
        if(!entity.isVisit())
            dto.setLastVisitDate(null);
        else{
            dto.setLastVisitDate(entity.getLastVisitDate().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")));
        }
        dto.setAddress(entity.getAddress());
        dto.setCategory(entity.getCategory());
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setImageLink(entity.getImageLink());
        dto.setRoadAddress(entity.getRoadAddress());
        dto.setHomePageLink(entity.getHomePageLink());

        return dto;
    }

    private WishListEntity dtoToEntity(WishListDto dto) {


        var entity = repository.findByTitle(dto.getTitle()).orElse(new WishListEntity());

        entity.setVisit(dto.isVisit());
        entity.setVisitCount(dto.getVisitCount());
        if(dto.getLastVisitDate()!=null)
            entity.setLastVisitDate(
                    LocalDateTime.parse(dto.getLastVisitDate(), DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")));
        entity.setAddress(dto.getAddress());
        entity.setCategory(dto.getCategory());
        entity.setTitle(dto.getTitle());
        entity.setImageLink(dto.getImageLink());
        entity.setRoadAddress(dto.getRoadAddress());
        entity.setHomePageLink(dto.getHomePageLink());

        return entity;
    }
    public WishListDto save(WishListDto wishListDto) {


        var entity = dtoToEntity(wishListDto);

        repository.save(entity);

        return entityToDto(entity);
    }

    public List<WishListDto> findAll(){
//        log.info("{}",id);
        repository.findAll().forEach(System.out::println);

        return repository.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public void delete(Long id) {
        System.out.println(id);
        log.info("{}",id);
        repository.delete(repository.findById(id).get());

    }

    public void addVisit(Long id) {
        var found = repository.findById(id).get();
        found.setVisit(true);

        var count = found.getVisitCount();
        found.setVisitCount(count+1);

        repository.save(found);
    }
}
