package com.pgiproject.pgiproject.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import com.pgiproject.pgiproject.Repository.MovieRepository;
import com.pgiproject.pgiproject.model.Movies;
@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movies> listAllMovies() {
        return  (List<Movies>) movieRepository.findAll();
        // List<MovieRepository> listUsers = movieRepository.findAll();
        // model.addAttribute("listUsers", listUsers);
    }

    public Movies saveMovie(Movies movies) {
        return movieRepository.save(movies);
    }

    public Movies getMovie(Integer id) {
        return movieRepository.findById(id).get();
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }
    public Movies updateMovie(Movies movies) {

        int myid=movies.getId();
         Movies obj=movieRepository.findById(myid).get();
          obj.setTitle(movies.getTitle());
          obj.setPrimary_director(movies.getPrimary_director()); 
          obj.setGenre(movies.getGenre());
          obj.setRating_id(movies.getRating_id());
        return movieRepository.save(movies);
    }

}