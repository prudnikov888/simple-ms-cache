package github.prudnikov.controller;

import github.prudnikov.pojo.Entry;
import github.prudnikov.service.EntryService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping(path = "/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveOrUpdate(@RequestBody Entry entry) {
        entryService.saveOrUpdate(entry);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/{key}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findByKey(@PathVariable String key) {
        Entry entry;
        try {
            entry = entryService.findByKey(key);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(entry, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{key}")
    public ResponseEntity delete(@PathVariable String key) {
        try {
            entryService.delete(key);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
