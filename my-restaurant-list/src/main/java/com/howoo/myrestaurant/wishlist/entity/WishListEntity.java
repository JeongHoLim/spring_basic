package com.howoo.myrestaurant.wishlist.entity;


import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
public class WishListEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String title;                   //음식명
    private String category;                //카테고리
    private String address;                 //주소
    private String roadAddress;             //도로명
    private String homePageLink;            //홈페이지 주소
    private String imageLink;               // 음식, 가게 이미지 주소
    private boolean isVisit;                // 방문 여부
    private int visitCount;                 //방문 카운트

    @LastModifiedDate
    private LocalDateTime lastVisitDate;    //마지막 방문 일자

}
