package com.driver;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void movieAdded(Movie movie) {
        movieRepository.movieAdd(movie);
    }

    public void directorAdded(Director director) {
        movieRepository.directorAdd(director);
    }

    public void movieDirectorPairAdded(String movieName, String directorName) {
        if (Objects.nonNull(movieRepository.findMovie(movieName))) {

        }
        movieRepository.movieDirectorPairAdd(movieName, directorName);
    }

    public Movie movidFind(String name) {
        return movieRepository.findMovie(name);
    }

    public Director directorFind(String name) {
        return movieRepository.findDirector(name);
    }

    public List<String> findMoviesFromDirector(String director) {
        return movieRepository.moviesFromDirectorFind(director);
    }

    public List<String> findMoviesAll(String director) {
        return movieRepository.allMoviesFind(director);
    }

    public void deleteDirector_ByName(String name) {
        movieRepository.deleteDirector_By_Name(name);
    }

    public void allDeleteDirector() {
    }

}
