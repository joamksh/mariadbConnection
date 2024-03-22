package com.example.mariaConnection.test;

import com.example.mariaConnection.test.Test;
import com.example.mariaConnection.test.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public String testServiceMethod(String str) {
        // Test 객체를 생성하여 전달받은 문자열을 설정
        Test test = Test.builder()
                .testContents(str)
                .build();

        // 데이터베이스에 Test 객체를 저장
        Test savedTest = testRepository.save(test);

        // 저장된 데이터의 ID 값을 반환
        return "hello " + savedTest.getTestId();
    }
}
