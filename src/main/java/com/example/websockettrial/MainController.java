package com.example.websockettrial;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.stream.Collectors;

@RestController
public class MainController {

  @GetMapping("/message")
  String getHelloMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Enumeration<String> headerNames = request.getHeaderNames();
    System.out.println("Headers: ");
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      String headerValue = request.getHeader(headerName);
      System.out.println("    " + headerName + ": " + headerValue);
    }
    System.out.println(request.getRequestURI());
    System.out.println(request.getRequestURL());
    request.getParameterMap().forEach((key, value) -> {
      System.out.println(key);
      for (String valueItem : value) {
        System.out.println(valueItem);
      }
    });

    return "Hello person!";
  }

  @GetMapping("/hello")
  String getHello() {
    return "Cat hello";
  }

}
