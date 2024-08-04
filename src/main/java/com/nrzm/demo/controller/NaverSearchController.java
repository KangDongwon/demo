package com.nrzm.demo.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin
public class NaverSearchController {

    private final String CLIENT_ID = "6AK7mTGZO1WCRAUTPzb2";
    private final String CLIENT_SECRET = "S0yLSV2H4z";
    private final String API_URL = "https://openapi.naver.com/v1/search/";

    @GetMapping("/api/search/{searchType}")
    public ResponseEntity<String> searchBlog(
            @PathVariable String searchType,
            @RequestParam String query,
            @RequestParam(defaultValue = "1") int start,
            @RequestParam(defaultValue = "10") int display) {

        // 헤더 세팅
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        // 파라미터 세팅
        String url = UriComponentsBuilder
                .fromHttpUrl(API_URL+searchType)
                .queryParam("query", query)
                .queryParam("start", start)
                .queryParam("display", display)
                .build(false)
                .toUriString();

        // 네이버 API 조회 요청
        RestTemplate restTemplate = new RestTemplate();

        try{
            return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        } catch (HttpClientErrorException e) {
            return ResponseEntity
                    .status(e.getStatusCode())
                    .body("잘못된 조회 요청: " + e.getStatusText());
        } catch (HttpServerErrorException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("시스템 오류 발생");
        }
    }
}

