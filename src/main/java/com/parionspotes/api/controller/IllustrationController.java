package com.parionspotes.api.controller;

import com.parionspotes.api.dto.IllustrationDto;
import com.parionspotes.api.model.Illustration;
import com.parionspotes.api.service.IllustrationService;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class IllustrationController {

    @Autowired
    IllustrationService illustrationService;

    @RequestMapping(value = "/illustrations", method = RequestMethod.GET) public @ResponseBody
    ResponseEntity<?> getAllIllustrations() {
        List<Illustration> illustrations = illustrationService.getAll();

        return ResponseEntity.ok(illustrations);
    }

    @RequestMapping(value = "/illustrations", method = RequestMethod.POST) public @ResponseBody
    ResponseEntity<?> add(@RequestBody IllustrationDto illustrationDto, @RequestParam MultipartFile file) {
        Blob blob = (Blob)file;
        Illustration createdIllustration = illustrationService.add(illustrationDto, blob);
        return ResponseEntity.ok(createdIllustration);
    }

    @RequestMapping(value = "/illustrations/{id}", method = RequestMethod.GET) public @ResponseBody
    ResponseEntity<?> getIllustration(@PathVariable Long id) {
        Illustration illustration = illustrationService.getById(id);
        if (illustration == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(illustration);
    }

    @Transactional
    @RequestMapping(value = "/illustrations/{id}", method = RequestMethod.DELETE) public @ResponseBody
    ResponseEntity<?> removeIllustration(@PathVariable Long id) {
        Integer nbRemoved = illustrationService.removeById(id);
        if (nbRemoved == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No illustration with id: " + id);
        }
        return ResponseEntity.ok("Illustration with id " + id + " removed");
    }
}