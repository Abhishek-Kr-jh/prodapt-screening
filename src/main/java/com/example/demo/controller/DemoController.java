package com.example.demo.controller;

import com.example.demo.error.ErrorResponse;
import com.example.demo.service.DemoService;
import com.example.demo.util.Constants;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/remove")
    public ResponseEntity<?> removeFirstAndLast(HttpServletRequest request) {


        String query = request.getQueryString();
        if (query == null) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Missing 'original' parameter"));
        }


        String original = null;

        // Find the index of "original=" and extract everything after it
        int index = query.indexOf("original=");
        if (index != -1) {
            original = query.substring(index + "original=".length());
        }


        if (original == null || original.length() < 2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(Constants.SHORT_STRING_ERROR_MESSAGE));
        }

        logger.info("Message received for processing {}", original);

        if (original == null || original.length() < 2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(Constants.SHORT_STRING_ERROR_MESSAGE));
        }

        try {
          return  ResponseEntity.ok(demoService.prosessString(original));
        } catch (Exception exception){
            logger.info("For {}, Exception occurred {}", original,exception.getMessage() );
            return ResponseEntity.internalServerError().body("Can't process Something went wrong..");
        }

    }
}
