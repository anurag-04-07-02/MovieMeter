package dev.anurag.movies;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies") // this annotation will let the framework know that this class belongs to a document in the movies collection
@Data // this takes care of all getter setters and toString methods
@AllArgsConstructor // this is for parameterized constructors
@NoArgsConstructor  // this is for non-parameterized constructors

public class Movie {
    
    @Id // this denotes it as an unique id for all movies 
    private ObjectId id;
    
    private String imdbId;
    
    private String title;
    
    private String releaseDate;
    
    private String trailerLink;
    
    private String poster;
    
    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference  // One to Many mapping
    private List<Review> reviewIds;
 
}
