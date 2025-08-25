package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    /*
    * Input: String
    * Output: String
    * Description: "Method will use to remove fist and last character of the string"
    */
    public String prosessString(String original){
        if (original.length() == 2) {
            return "";
        }
        return original.substring(1, original.length() - 1);
    }
}
