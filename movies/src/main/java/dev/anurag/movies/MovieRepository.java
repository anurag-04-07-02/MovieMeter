// it is the data access layer which talks with the database and brings us the data
package dev.anurag.movies;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie,ObjectId> { // Movie is the class that the repository will manage

    Optional<Movie> findByImdbId(String imdbId);  
    // spring will understand what do we mean by findByImdbId. It is that much intelligent 
    
}
