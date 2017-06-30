package com.parionspotes.api.controller;

import com.parionspotes.api.model.Illustration;
import com.parionspotes.api.service.IllustrationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class IllustrationController {

    @Autowired
    IllustrationService illustrationService;

    @RequestMapping(value = "/illustrations", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> getAllIllustrations() {
        List<Illustration> illustrations = illustrationService.getAll();

        return ResponseEntity.ok(illustrations);
    }

    @RequestMapping(value = "/illustrations", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<?> add(@RequestBody Illustration illustration) {
        Illustration createdIllustration = illustrationService.add(illustration);
        return ResponseEntity.ok(createdIllustration);
    }

    @RequestMapping(value = "/illustrations/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> getIllustration(@PathVariable Long id) throws NotFoundException {
        Illustration illustration = illustrationService.getById(id);
        if (illustration == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(illustration);
    }
}