package netflixclone.NetflixAssignment.controller;

import netflixclone.NetflixAssignment.feignclient.MovieDbApi;
import netflixclone.NetflixAssignment.feignclient.MovieResponse;
import netflixclone.NetflixAssignment.feignclient.genre.MovieGenres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontEndController {

    private String lang = "en-US";
   // private String api = "4b9e0a6d10b150a86ea776f903aaaf8c";


    // Injecting Interface Feign Class
    @Autowired
    private MovieDbApi movieDbApi;


    // Top Rated movie request from frontend
    @GetMapping("/movies/toprated")
    public MovieResponse getTopRatedMovies(){
        System.out.println(" ---> Movies TopRated request from frontend");
        return movieDbApi.getTopRatedMovies(lang);
    }

    // Genre movie request from frontend
    @GetMapping("/movies/genres")
    public MovieGenres getMovieGenres(){
        System.out.println(" ---> Movies genre request from frontend");
        return movieDbApi.getMovieGenres(lang);
    }


}
