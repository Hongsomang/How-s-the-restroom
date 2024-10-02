package com.restroom.restroom.controller;

import com.restroom.restroom.model.Restroom;
import com.restroom.restroom.service.PublicDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@RequestMapping("/public-data")
public class PublicDataController {
    final
    PublicDataService publicDataService;

    public PublicDataController(PublicDataService publicDataService) {
        this.publicDataService = publicDataService;
    }

    @ResponseBody
    @GetMapping("/reset")
    public ResponseEntity<List<Restroom>> reset(@RequestParam int categoryCode) throws IOException, NoSuchAlgorithmException, KeyManagementException {
       List<Restroom> list =publicDataService.reset(categoryCode);

        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
