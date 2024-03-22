package com.example.mariaConnection.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    @GetMapping("/test/{str}")
    public String test(@PathVariable String str) {
        // TestService의 testServiceMethod를 호출하여 반환된 문자열을 그대로 반환
        String result = testService.testServiceMethod(str);

        return result;
    }
}
