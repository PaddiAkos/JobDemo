package com.example.project.job.demo.service.impl;

import com.example.project.job.demo.dto.AdDto;
import com.example.project.job.demo.model.Ad;
import java.util.List;

public interface AdService {

    Ad findById (Long Ad_id);

    List<AdDto> findAll();

    void deleteAd(Long Ad_id);

    void createAd(AdDto createAd);

    void updateAd(AdDto adDto, Long Ad_id);

}

