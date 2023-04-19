package com.cnu.ad.controller;

import com.cnu.ad.model.Advertisement;
import com.cnu.ad.service.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdController {
    private final AdService adService;

    @GetMapping
    public Advertisement getAdd() {return adService.getAd(); }
}