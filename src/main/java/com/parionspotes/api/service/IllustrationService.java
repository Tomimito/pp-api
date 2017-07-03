package com.parionspotes.api.service;

import com.parionspotes.api.dto.IllustrationDto;
import com.parionspotes.api.model.Illustration;
import com.parionspotes.api.repository.IllustrationRepository;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;

/**
 * Created by Thomas on 25/06/2017.
 */
@Service
public class IllustrationService {

    private IllustrationRepository illustrationRepository;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setIllustrationRepository(IllustrationRepository illustrationRepository) {
        this.illustrationRepository = illustrationRepository;
    }

    public List<Illustration> getAll() {
        return illustrationRepository.findAll();
    }

    public Illustration add(IllustrationDto illustrationDto, MultipartFile file) {
        Blob blob = null;
        try {
            blob = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(file.getInputStream(),file.getSize());
        } catch (HibernateException e) {
            // ...
        } catch (IOException e) {
            // ...
        }
        Illustration illustration = new Illustration(illustrationDto, blob);
        return illustrationRepository.save(illustration);
    }

    public Illustration getById(Long id) {
        return illustrationRepository.findOne(id);
    }

    public Integer removeById(Long id) {
        return illustrationRepository.removeById(id);
    }
}
