package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieMap;
    HashMap<String, Director> directorMap;
    HashMap<String, List<String>> movieDirectorPairMap;

    public MovieRepository(){
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.movieDirectorPairMap = new HashMap<>();

    }

    public void movieAdd(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public void directorAdd(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void movieDirectorPairAdd(String movieName, String directorName) {
        // List<String> pair = new ArrayList<>();
        // if (movieDirectorPairMap.containsKey(directorName)) {
        // pair = movieDirectorPairMap.get(directorName);
        // }
        // pair.add(movieName);
        // movieDirectorPairMap.put(directorName, pair);

        if (movieDirectorPairMap.containsKey(directorName)) {
            List<String> pair = movieDirectorPairMap.get(directorName);
            pair.add(movieName);
            movieDirectorPairMap.put(directorName, pair);
        }
    }

    public Movie findMovie(String movieName) {
        return movieMap.get(movieName);
    }

    public Director findDirector(String name) {
        return directorMap.get(name);
    }

    public List<String> moviesFromDirectorFind(String director) {
        List<String> allMovie = new ArrayList<>();
        if (movieDirectorPairMap.containsKey(director)) {
            allMovie = movieDirectorPairMap.get(director);
        }
        return allMovie;
    }

    public List<String> allMoviesFind(String director) {
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector_By_Name(String name) {
        directorMap.remove(name);
    }

}
