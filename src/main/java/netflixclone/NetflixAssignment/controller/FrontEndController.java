package netflixclone.NetflixAssignment.controller;

import netflixclone.NetflixAssignment.feignclient.MovieDbApi;
import netflixclone.NetflixAssignment.view.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.view.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.view.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.view.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.service.MovieService;
import netflixclone.NetflixAssignment.view.searchResults.SearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontEndController {

    private String lang = "en-USs";
    private String include_adult = "false";


    @Value("${tmdb.api_key}")
    private String api_key;

    // Injecting Interface Feign Class
    @Autowired
    private MovieDbApi movieDbApi;



    @GetMapping("/")
    public String defaultPageAnswer(){
        return "use:" +
                " /movies/toprated/{pageNr}" +
                "or: /movie/details/{movieId}" +
                "or: /movies/genres" +
                "or: /search/{query}";
    }


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


//-----------------------------------Via Service class-------------------------------------------------
//    // Movies by genre request from frontend
//    @GetMapping("/movies/genre/{genreId}")
//    public MoviesByGenre getMoviesByGenre(@PathVariable String genreId){
//        System.out.println(" ---> Movies genre with id:"+ genreId +" requested from frontend");
//        return MovieService.getMoviesByGenre(api_key, genreId);
//    }
//-----------------------------------------------------------------------------------------------

    // Genre-types movie request from frontend
    @GetMapping("/search/{query}")
    public SearchResults getSearchResult(@PathVariable String query){
        System.out.println(" ---> Search request from frontend");
        return movieDbApi.getSearchResult(api_key, lang, query);
    }




}
