package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.testUtil.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Skeleton template for a controller test using MockMvc.
 *
 * You can use annotations from JUnit 5 such as @ParameterizedTest, @ValueSauce,
 * @CsvSource and @MethodSource for your test data.
 *
 * Example usage of mockMvc for a GET request
 * mockMvc.perform(get("/path-to-your-endpoint").param("your-query-param", param-value))
 *                 .andExpect(status().whateverStatusCodeYouExpect())
 *                 .andExpect(content().string("string-you-expect-in-response")).
 *                 .andExpect(jsonPath("$.jsonField").value("json-value-you-expect"));
 */
@SpringBootTest
@AutoConfigureMockMvc
//class DemoControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void testBasicWords() throws Exception {
//        mockMvc.perform(get("/remove").param("original", "eloquent"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("loquen"));
//
//        mockMvc.perform(get("/remove").param("original", "country"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("ountr"));
//
//        mockMvc.perform(get("/remove").param("original", "person"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("erso"));
//    }
//
//    @Test
//    void testTwoCharacterString() throws Exception {
//        mockMvc.perform(get("/remove").param("original", "ab"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(""));
//    }
//
//    @Test
//    void testThreeCharacterString() throws Exception {
//        mockMvc.perform(get("/remove").param("original", "xyz"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("y"));
//    }
//
//    @Test
//    void testNumbersAndSpecialCharacters() throws Exception {
//        mockMvc.perform(get("/remove").param("original", "123%qwerty+"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("23%qwerty"));
//    }
//
//    @Test
//    void testTooShortStrings() throws Exception {
//        mockMvc.perform(get("/remove").param("original", "a"))
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("$.message").value(Constants.SHORT_STRING_ERROR_MESSAGE));
//
//        mockMvc.perform(get("/remove").param("original", ""))
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("$.message").value(Constants.SHORT_STRING_ERROR_MESSAGE));
//    }
//
//}



class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testEloquent() throws Exception {
        mockMvc.perform(get("/remove?original=eloquent"))
                .andExpect(status().isOk())
                .andExpect(content().string("loquen"));
    }

    @Test
    void testCountry() throws Exception {
        mockMvc.perform(get("/remove?original=country"))
                .andExpect(status().isOk())
                .andExpect(content().string("ountr"));
    }

    @Test
    void testPerson() throws Exception {
        mockMvc.perform(get("/remove?original=person"))
                .andExpect(status().isOk())
                .andExpect(content().string("erso"));
    }

    @Test
    void testTwoCharacters() throws Exception {
        mockMvc.perform(get("/remove?original=ab"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void testThreeCharacters() throws Exception {
        mockMvc.perform(get("/remove?original=xyz"))
                .andExpect(status().isOk())
                .andExpect(content().string("y"));
    }



    @Test
    void testTooShortString() throws Exception {
        mockMvc.perform(get("/remove?original=a"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message")
                        .value("Input string must have at least 2 characters"));
    }

}
