package com.example.mariaConnection.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private UserDto user; // 사용자 정보
    private String title; // 게시물 제목
    private int price; // 게시물 가격
    private List<String> images; // 게시물 이미지 URL 목록
    private String contents; // 게시물 내용
    private int groupSize; // 그룹 크기
    private int curGroupSize; // 현재 그룹 크기
    private LocalDateTime closedAt; // 게시물 마감 시간
    private List<PostIngredientDto> postIngredients; // 포스트 재료 목록
}