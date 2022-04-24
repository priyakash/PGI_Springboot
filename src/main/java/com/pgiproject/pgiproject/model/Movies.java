package com.pgiproject.pgiproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies {

    public Movies(Integer id, String title, String primary_director, String year_released, String genre, Integer rating_id) {
        this.id = id;
        this.title = title;
        this.primary_director = primary_director;
        this.year_released = year_released;
        this.genre = genre;
        this.rating_id = rating_id;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable=false,updatable=false)
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    private String title;
    private String primary_director;
    private String year_released;
    private String genre;
    private Integer rating_id;

    // public Integer getId() {
    //     return this.id;
    // }


    public Integer getRating_id() {
        return this.rating_id;
    }

    public void setRating_id(Integer rating_id) {
        this.rating_id = rating_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimary_director() {
        return this.primary_director;
    }

    public void setPrimary_director(String primary_director) {
        this.primary_director = primary_director;
    }

    public String getYear_released() {
        return this.year_released;
    }

    public void setYear_released(String year_released) {
        this.year_released = year_released;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
  
   
    public Movies(){
 }
  
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    public int getId() {
//        return id;
//    }

// public void setId(Integer id2) {
// }

}
