package com.pgiproject.pgiproject.Controller;

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
 @RequestMapping("/movies")
public class MovieController {



    // @RequestMapping("/")  
    // public String hello()   
    // {  
    // return "Hello User";  
    // }  

    @Autowired
    MovieService movieService;




    @GetMapping("/")
    public List<Movies> list() {
        return movieService.listAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> get(@PathVariable Integer id) {
        try {
            Movies movies = movieService.getMovie(id);
            return new ResponseEntity<Movies>(movies, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Movies>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Movies movies) {
        movieService.saveMovie(movies);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Movies movies, @PathVariable Integer id) {
        try {
            Movies existUser = movieService.getMovie(id);
            System.out.println(existUser +" : existUser");
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