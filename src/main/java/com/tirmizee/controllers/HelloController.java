package com.tirmizee.controllers;

import com.tirmizee.transfers.MockRequest;
import com.tirmizee.transfers.MockResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class HelloController {

    @PostMapping("/post")
    public MockResponse post(@RequestBody MockRequest request) {
        MockResponse response = new MockResponse();
        response.setResId(request.getReqId() + UUID.randomUUID());
        response.setResName(request.getReqName() + UUID.randomUUID());
        return response;
    }

    @PostMapping("/get")
    public MockResponse get() {
        MockResponse response = new MockResponse();
        response.setResId(UUID.randomUUID().toString());
        response.setResName(UUID.randomUUID().toString());
        return response;
    }

}
