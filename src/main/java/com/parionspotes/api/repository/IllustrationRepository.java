package com.parionspotes.api.repository;

import com.parionspotes.api.model.Illustration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Thomas on 25/06/2017.
 */
public interface IllustrationRepository extends CrudRepository<Illustration, Long> {
    List<Illustration> findAll();
    Illustration findOneById(Long id);
    Integer removeById(Long id);
}