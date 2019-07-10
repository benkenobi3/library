package com.benkenobi3.library.controllers;

import com.benkenobi3.library.exceptions.NotFoundException;
import com.benkenobi3.library.models.Library;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableSwagger2
@RestController
@RequestMapping("library")
public class LibraryController {

    private int counter = 0;

    private Map<String, Library> libraries = new HashMap<>();

    @GetMapping
    public Map<String, Library> getLibs() {return libraries;}

    @GetMapping("{id}")
    public Library getLibById(@PathVariable String id) {
        if (libraries.containsKey(id))
            return libraries.get(id);
        throw new NotFoundException();
    }

    @PostMapping
    public Library createLib(@RequestBody String name) {
        libraries.put(Integer.toString(counter), new Library(name));
        counter++;
        return libraries.get(Integer.toString(counter-1));
    }

    @PutMapping("{id}")
    public Library updateLibById(@PathVariable String id, @RequestBody String name) {
        Library library = getLibById(id);
        library.setName(name);
        return library;
    }

    @DeleteMapping("{id}")
    public void deleteLibById(@PathVariable String id) {
        if (libraries.containsKey(id))
            libraries.remove(id);
        else
            throw new NotFoundException();
    }

}
