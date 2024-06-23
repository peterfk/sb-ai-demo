package com.example.sb_ai_demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb_ai_demo.entities.Imaging;
import com.example.sb_ai_demo.services.ImagingService;

@RestController
@RequestMapping("/api/imaging")
public class ImagingController {

    @Autowired
    private ImagingService imagingService;

    @GetMapping
    public List<Imaging> getAllImagings() {
        return imagingService.getAllImagings();
    }

    // @GetMapping("/{imagingId}")
    // public Imaging getImaging(@PathVariable int imagingId) {
    //     return imagingService.getImaging(imagingId);
    // }

    // @PostMapping
    // public Imaging createImaging(@RequestBody Imaging imaging) {
    //     return imagingService.createImaging(imaging);
    // }

    // @PutMapping("/{imagingId}")
    // public Imaging updateImaging(@PathVariable int imagingId, @RequestBody Imaging imaging) {
    //     return imagingService.updateImaging(imagingId, imaging);
    // }

    @DeleteMapping("/{imagingId}")
    public void deleteImaging(@PathVariable int imagingId) {
        imagingService.deleteImaging(imagingId);
    }
}

