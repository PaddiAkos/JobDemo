package com.example.project.job.demo.controller;

import com.example.project.job.demo.dto.AdDto;
import com.example.project.job.demo.model.Ad;
import com.example.project.job.demo.service.impl.impl.DataServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/f1/ad")
@RequiredArgsConstructor
public class AdController {

    private final DataServiceImpl dataService;

    @GetMapping("/AllAd")
    public ResponseEntity<List<AdDto>> getAll() {
        return ResponseEntity.ok(dataService.findAll());

}

    @GetMapping("/{Ad_id}")
    public ResponseEntity<Ad> getAdById(@PathVariable(name = "Ad_id") Long Ad_id) {
        return ResponseEntity.ok(dataService.findById(Ad_id));

}

    @PutMapping("/{Ad_id}")
    public ResponseEntity<Void> updateAd(@RequestBody @Valid AdDto adDto, @PathVariable(name = "Ad_id") Long Ad_id) {
    dataService.updateAd(adDto, Ad_id);
        return ResponseEntity.ok().build();
}

    @PostMapping
    public ResponseEntity<Void> createAd(@RequestBody @Valid AdDto createAd) {
        dataService.createAd(createAd);
        return ResponseEntity.ok().build();
}

    @DeleteMapping("/{Ad_id}")
    public ResponseEntity<Void> deleteAd(@PathVariable(name = "Ad_id") Long Ad_id) {
        dataService.deleteAd(Ad_id);
        return ResponseEntity.ok().build();

    }
 }




