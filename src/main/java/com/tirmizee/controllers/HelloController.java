package com.tirmizee.controllers;

import com.tirmizee.transfers.MockRequest;
import com.tirmizee.transfers.MockResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class HelloController {

    @PostMapping("/post")
    public MockResponse post(@RequestBody MockRequest request) {
        MockResponse response = new MockResponse();
        response.setResId(request.getReqId() + UUID.randomUUID());
        response.setResName(request.getReqName() + UUID.randomUUID());
        return response;
    }

    @GetMapping("/get")
    public MockResponse get() {
        log.info("HelloController.get");
        MockResponse response = new MockResponse();
        response.setResId(UUID.randomUUID().toString());
        response.setResName(UUID.randomUUID().toString());
        return response;
    }

}
