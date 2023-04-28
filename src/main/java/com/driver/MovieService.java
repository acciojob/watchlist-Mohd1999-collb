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
        if (Objects.nonNull(movieRepository.findMovie(movieName))
                && Objects.nonNull(movieRepository.findDirector(directorName))) {
            movieRepository.movieDirectorPairAdd(movieName, directorName);
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

    public List<String> findMoviesAll() {
        return movieRepository.allMoviesFind();
    }

    public void deleteDirector_ByName(String name) {
        List<String> moviesToDelete = movieRepository.moviesFromDirectorFind(name);
        movieRepository.removeDirector(name);
        for (String movieName : moviesToDelete) {
            movieRepository.removeMovie(movieName);
        }
    }

    public void allDeleteDirector() {
        List<String> director = movieRepository.getAllDirector();
        for (String directorName : director) {
            deleteDirector_ByName(directorName);
        }
    }

}
