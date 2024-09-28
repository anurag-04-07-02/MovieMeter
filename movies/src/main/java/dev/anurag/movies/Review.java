package dev.anurag.movies;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {

    @Id
    private ObjectId id;
    private String body;

    // there is all args constructor and a no args constructor, but we need a custom constructor.
    public Review(String body){
        this.body=body;
    }
    
}
