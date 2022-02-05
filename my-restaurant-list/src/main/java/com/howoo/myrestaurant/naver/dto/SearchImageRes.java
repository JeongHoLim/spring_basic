package com.howoo.myrestaurant.naver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchImageRes {

    private String lastBuildDate;

    private List<SearchImageResItem> items;
    private int total;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchImageResItem{
        private String title;
        private String link;
        private String thumbnail;

    }
}
