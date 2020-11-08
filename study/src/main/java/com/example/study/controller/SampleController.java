package com.example.study.controller;


import com.example.study.model.SampleParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SampleControll")
public class SampleController {

    @GetMapping("/hi")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/id")
    public String getParam(@RequestParam String id, String name){
        return "id : " + id + ", name : " + name;

    }

    @GetMapping("/multiParams")
    public SampleParam multiParam(SampleParam samplepParam){

        return samplepParam;

    }

    @PostMapping("/postParams")
    public SampleParam post(@RequestBody SampleParam sampleParams){

        return sampleParams;
    }

}
