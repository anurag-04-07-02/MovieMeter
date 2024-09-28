package dev.anurag.movies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired // instantiate the movieRepository object
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll(); // findall() is a built-in function of movieRepository class
    }

    public Optional<Movie> singleMovie(String imdbId){  // this return type indicates that if id is invalid then
        return movieRepository.findByImdbId(imdbId);         // it will return NULL    
    }
    
}
