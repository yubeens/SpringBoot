package com.example.thymeleafex.controller;

import com.example.thymeleafex.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class SampleController {
    @GetMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("msg", "Hello World");
    }
    @GetMapping("/arr")
    public void arrData(Model model) {
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        model.addAttribute("list", list);
    }
    @GetMapping("/ex01")
    public void ex01() {
    }
    @GetMapping("/ex02")
    public void ex02(Model model) {
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        model.addAttribute("list", list);

        Map<String, Integer> maps=new HashMap<>();
        maps.put("홍길동",80);
        maps.put("박경미",75);
        maps.put("윤요섭",85);
        model.addAttribute("maps", maps);

        SampleDTO sampleDTO=new SampleDTO();
        sampleDTO.setName("hong");
        sampleDTO.setAge(20);
        sampleDTO.setGender("남자");

        model.addAttribute("sampleDTO", sampleDTO);
    }
    @GetMapping("/hello1")
    public void hello1(String name, int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
    }
    @GetMapping("/hello2")
    public void hello2(@RequestParam("name") String name,
                       @RequestParam("age") int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
    }
    @GetMapping("/hello3")
    public void hello3(@RequestParam(name="types")
                       List<String> types, int age, Model model) {
        model.addAttribute("types", types);
        model.addAttribute("age", age);
    }

    @GetMapping("/ex/ex001")
    public void ex001() {
    }
    @GetMapping("/sample")
    public void sample(){
    }

}
