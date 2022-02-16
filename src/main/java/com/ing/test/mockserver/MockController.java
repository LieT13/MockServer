package com.ing.test.mockserver;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MockController {

    @GetMapping(value = "/mock")
    public void getMock() throws InterruptedException {
        log.info("New request to /mock GET endpoint");
    }

    @GetMapping(value = "/mockSleep5000")
    public ResponseEntity getMockSleep5000() throws InterruptedException {
        log.info("New request to /mockSleep5000 GET endpoint");
        log.info("Sleeping 5000 millis");
        Thread.sleep(5000);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(value = "/mockSleep10000")
    public ResponseEntity getMockSleep10000() throws InterruptedException {
        log.info("New request to /mockSleep10000 GET endpoint");
        log.info("Sleeping 10000 millis");
        Thread.sleep(10000);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(value = "/mockStatus/{httpStatus}")
    public ResponseEntity getMockConnectionClosed(@PathVariable(value = "httpStatus") int httpStatus) {
        log.info("New request to /mockStatus with status {}", httpStatus);
        return ResponseEntity.status(httpStatus).build();
    }

}
