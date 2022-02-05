package com.howoo.myrestaurant.naver;

import com.howoo.myrestaurant.naver.dto.SearchImageReq;
import com.howoo.myrestaurant.naver.dto.SearchImageRes;
import com.howoo.myrestaurant.naver.dto.SearchLocalReq;
import com.howoo.myrestaurant.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class Naver {


    @Value("${naver.search.url.local}")
    private String searchLocalUrl;

    @Value("${naver.search.url.image}")
    private String searchImageUrl;

    @Value("${naver.client.id}")
    private String clientId;

    @Value("${naver.client.secret}")
    private String secret;

    public SearchLocalRes searchLocal(SearchLocalReq req){
        URI uri = UriComponentsBuilder
                .fromUriString(searchLocalUrl)
                .queryParams(req.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id",clientId);
        headers.set("X-Naver-Client-Secret",secret);

        var httpEntity = new HttpEntity<>(headers);

        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){};

        var responseEntity = new RestTemplate()
                .exchange(
                        uri, HttpMethod.GET,httpEntity,responseType
                );

        return responseEntity.getBody();
    }

    public SearchImageRes searchImage(SearchImageReq req){

        URI uri = UriComponentsBuilder
                .fromUriString(searchImageUrl)
                .queryParams(req.toMultiValueMap())
                .build()
                .encode().toUri();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id",clientId);
        headers.set("X-Naver-Client-Secret",secret);

        var httpEntity = new HttpEntity<>(headers);

        var responseType = new ParameterizedTypeReference<SearchImageRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,HttpMethod.GET,httpEntity,responseType
        );

        return responseEntity.getBody();
    }
}
