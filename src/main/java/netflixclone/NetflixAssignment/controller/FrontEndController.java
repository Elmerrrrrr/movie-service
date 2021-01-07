package netflixclone.NetflixAssignment.controller;

import netflixclone.NetflixAssignment.feignclient.MovieDbApi;
import netflixclone.NetflixAssignment.feignclient.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.feignclient.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.feignclient.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.feignclient.moviesTopRated.MoviesTopRated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class FrontEndController {

    private String lang = "en-US";

    @Value("${tmdb.api_key}")
    private String api_key;

    // Injecting Interface Feign Class
    @Autowired
    private MovieDbApi movieDbApi;




    // Top Rated movie request from frontend
    @GetMapping("/movies/toprated/{pageNr}")
    public MoviesTopRated getTopRatedMovies(@PathVariable String pageNr){
        System.out.println(" ---> Movies TopRated requested from frontend");
        return movieDbApi.getTopRatedMovies(api_key, lang, pageNr);
    }


    // Single movie detail request from frontend
     @GetMapping("/movie/details/{movieId}")
     public MovieDetails getMovieDetails(@PathVariable String movieId){
         System.out.println(" ---> Movie details with id:"+ movieId +" requested from frontend");
         return movieDbApi.getMovieDetails(movieId, api_key, lang);
   }


    // Genre-types movie request from frontend
    @GetMapping("/movies/genres")
    public MovieGenres getMovieGenres(){
        System.out.println(" ---> Movies genre requested from frontend");
        return movieDbApi.getMovieGenres(api_key, lang);
    }


    // Movies by genre request from frontend
    @GetMapping("/movies/genre/{genreId}")
    public MoviesByGenre getMoviesByGenre(@PathVariable String genreId){
        System.out.println(" ---> Movies genre with id:"+ genreId +" requested from frontend");
        return movieDbApi.getMoviesByGenre(api_key, genreId);
    }




}
