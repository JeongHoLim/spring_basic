package com.howoo.myrestaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchLocalRes {

    private String lastBuildDate;
    private String category;
    private int total;
    private List<SearchLocalResItem> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor

    public static class SearchLocalResItem{
        private String title;
        private String link;
        private String description;
        private String telephone;
        private String address;
        private String category;
        private String roadAddress;
        private int mapx;
        private int mapy;
    }
}
