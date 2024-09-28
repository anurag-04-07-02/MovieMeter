package dev.anurag.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    
    public Review createReview(String body, String imdbId){

        Review review = reviewRepository.insert(new Review(body));

        //now we have to associate this review to a movie

        // for that we need to create a MongoTemplate which will interact with the database.
        // repository is not a suitable option in this type of complex operation.

        // now we will write a query just as we write a sql query.

        mongoTemplate.update(Movie.class)
                     .matching(Criteria.where("imdbId").is(imdbId))
                     .apply(new Update().push("reviewIds").value(review))
                     .first(); 
        
        return review;

    }
}
