package netflixclone.NetflixAssignment.feignclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import netflixclone.NetflixAssignment.model.movieImagesFA.MovieImagesFA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//this fallback class should also be a Bean
@Service
public class FallBackFanArtApi implements FanArtApi {

    @Autowired
    ObjectMapper mapper;

    @Override
    public MovieImagesFA getMovieImages(int movieId, String api_key) {
        MovieImagesFA errorObject = new MovieImagesFA();
        errorObject.setFallBackError("Internal Server Error");

        System.out.println("fallBack method invoked");

        return errorObject;
    }



}
