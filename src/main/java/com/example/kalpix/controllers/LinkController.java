package com.example.kalpix.controllers;

import com.example.kalpix.services.ILinkService;
import com.example.kalpix.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController()
@RequestMapping("/api/links")
public class LinkController {
    public final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }
    @GetMapping("/all")
    public ApiResponse getLinks() {
        return new ApiResponse(HttpStatus.OK, true, "Links fetched", linkService.getAllLinks());
    }

    @PostMapping("/create")
    public ApiResponse createStudent(@RequestBody() String webpage) throws IOException {
        return new ApiResponse(HttpStatus.OK, true, "Links saved", linkService.saveLink(webpage));
    }
}
