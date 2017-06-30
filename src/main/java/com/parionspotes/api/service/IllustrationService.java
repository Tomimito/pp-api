package com.parionspotes.api.service;

import com.parionspotes.api.model.Illustration;
import com.parionspotes.api.repository.IllustrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Thomas on 25/06/2017.
 */
@Service
public class IllustrationService {

    private IllustrationRepository illustrationRepository;

    @Autowired
    public void setIllustrationRepository(IllustrationRepository illustrationRepository) {
        this.illustrationRepository = illustrationRepository;
    }

    public List<Illustration> getAll() {
        return illustrationRepository.findAll();
    }

    public Illustration add(Illustration illustration) {
        return illustrationRepository.save(illustration);
    }

    public Illustration getById(Long id) {
        return illustrationRepository.findOne(id);
    }
}
