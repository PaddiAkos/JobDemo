package com.example.project.job.demo.service.impl.impl;

import com.example.project.job.demo.dto.AdDto;
import com.example.project.job.demo.exception.EntityNotFoundException;
import com.example.project.job.demo.model.Ad;
import com.example.project.job.demo.repository.AdRepository;
import com.example.project.job.demo.service.impl.AdService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class DataServiceImpl implements AdService {

    private final AdRepository adRepository;

    public DataServiceImpl(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @Override
    public Ad findById(Long Ad_id) {

        log.trace("Find_By_ID {}", Ad_id);

        return adRepository.findById(Ad_id)
                .orElseThrow(() -> new EntityNotFoundException(Ad.class, Map.of("Ad_id", Ad_id.toString())));
    }

    @Override
    public List<AdDto> findAll() {

        log.trace("Find_All_AdDto");

        List<Ad> adlist = adRepository.findAll();

        return adlist.stream()
                .map(ad ->
                {
                    AdDto comp = new AdDto();
                    comp.setText(ad.getText());
                    comp.setTitle(ad.getTitle());
                    comp.setImageId(ad.getImageId());

                    return comp;
                })
                .collect(Collectors.toList());
    }
    @Override
    public void deleteAd(Long AdId) {

        log.trace("Delete_Ad_by_Id");

        adRepository.deleteById(AdId);

    }

    @Override
    public void createAd(AdDto adDto) {

        log.trace("Create_Ad {}", adDto);

        Ad ad1 = new Ad();
        ad1.setText(adDto.getText());
        ad1.setTitle(adDto.getTitle());
        ad1.setImageId(adDto.getImageId());
        ad1.setCreatedDate(new Date());
        adRepository.save(ad1);

    }

    @Override
    public void updateAd(AdDto adDto, Long Ad_id) {

        log.trace("Update_Ad_with_id {}", Ad_id);

        Ad ad = findById(Ad_id);
        ad.setText(adDto.getText());
        ad.setTitle(adDto.getTitle());
        ad.setImageId(adDto.getImageId());
        ad.setLastModifiedDate(new Date());
        adRepository.save(ad);

    }
}


