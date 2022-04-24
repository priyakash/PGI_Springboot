package com.pgiproject.pgiproject.Controller;

import java.io.Console;
import java.util.List;

import com.pgiproject.pgiproject.model.Movies;
import com.pgiproject.pgiproject.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgiproject.pgiproject.Repository.MovieRepository;
import com.pgiproject.pgiproject.model.Movies;

import com.pgiproject.pgiproject.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class homecontroller {
    /*
     * @RequestMapping("/")
     * public String hello()
     * {
     * return "Greetings from Spring Boot!";
     * }
     */

    @Autowired
    MovieService movieService;

    @RequestMapping("/all")
    public List<Movies> list() {
        System.out.println(movieService.listAllMovies());
        return movieService.listAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> get(@PathVariable Integer id) {
        try {
            Movies movies = movieService.getMovie(id);
            System.out.println(movies);
            return new ResponseEntity<Movies>(movies, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Movies>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(@RequestBody Movies movies) {
        movieService.saveMovie(movies);
    }

    @PutMapping("/update")
    public Movies update(@RequestBody Movies movies) {
        System.out.println(movies + "movies");

        return movieService.updateMovie(movies);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Movies movies, @PathVariable Integer id) {
        try {
            System.out.println("my val" + id);
            Movies existUser = movieService.getMovie(id);
            System.out.println("ok");
            System.out.println(existUser);
            movies.setId(id);
            movieService.saveMovie(movies);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        movieService.deleteMovie(id);
    }

}
