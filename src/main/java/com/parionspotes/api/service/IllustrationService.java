package com.parionspotes.api.service;

import com.parionspotes.api.dto.IllustrationDto;
import com.parionspotes.api.model.Illustration;
import com.parionspotes.api.repository.IllustrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Blob;
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

    public Illustration add(IllustrationDto illustrationDto, Blob file) {
        Illustration illustration = new Illustration(illustrationDto, file);
        return illustrationRepository.save(illustration);
    }

    public Illustration getById(Long id) {
        return illustrationRepository.findOne(id);
    }

    public Integer removeById(Long id) {
        return illustrationRepository.removeById(id);
    }
}
