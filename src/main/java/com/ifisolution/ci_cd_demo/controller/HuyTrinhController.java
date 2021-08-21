package com.ifisolution.ci_cd_demo.controller;

import com.ifisolution.ci_cd_demo.response.HuyTrinhResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/huytrinh")
public class HuyTrinhController {
    @GetMapping
    public ResponseEntity<HuyTrinhResponse> getInfo(){
        HuyTrinhResponse huyTrinhResponse = new HuyTrinhResponse();
        huyTrinhResponse.setName("Huy Trinh");
        huyTrinhResponse.setAge(21);
        huyTrinhResponse.setSingle(true);

        return new ResponseEntity<>(huyTrinhResponse, HttpStatus.OK);
    }

}
