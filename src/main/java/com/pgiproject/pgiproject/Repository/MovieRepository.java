package com.pgiproject.pgiproject.Repository;

import com.pgiproject.pgiproject.model.Movies;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movies,Integer> 
{}   




