package netflixclone.NetflixAssignment.controller;

import netflixclone.NetflixAssignment.dto.moviesBannerIntro.BannerIntroMovies;
import netflixclone.NetflixAssignment.dto.moviesByPeriod.MoviesByPeriod;
import netflixclone.NetflixAssignment.feignclient.MovieDbApi;
import netflixclone.NetflixAssignment.dto.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.dto.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.dto.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.dto.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.service.MovieService;
import netflixclone.NetflixAssignment.dto.searchResults.SearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FrontEndController {

    private final String lang = "en-US";
    private final String include_adult = "false";
    private final String with_original_language = "en";
    private final String include_video = "true";


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
         return movieDbApi.getMovieDetails(movieId, api_key, lang, include_video);
   }

    // Get introBanner movie request from frontend
    @GetMapping("/movies/introBanner")
    public BannerIntroMovies getBannerIntroMovie(){
        System.out.println(" ---> Intro banner movie request from frontend");
        return movieDbApi.getBannerIntroMovie(api_key, lang, include_video, "213");
    }




    /* ------------------Genre Requests------------------ */

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
//        MoviesByGenre newMoviesByGenre = new MoviesByGenre();
//        newMoviesByGenre.getResults();
        return movieDbApi.getMoviesByGenre(api_key, genreId, lang, include_video, with_original_language);
    }


//-----------------------------------Via Service class-------------------------------------------
//    // Movies by genre request from frontend
//    @GetMapping("/movies/genre/{genreId}")
//    public MoviesByGenre getMoviesByGenre(@PathVariable String genreId){
//        System.out.println(" ---> Movies genre with id:"+ genreId +" requested from frontend");
//        return MovieService.getMoviesByGenre(api_key, genreId);
//    }
//-----------------------------------------------------------------------------------------------



    /* ------------------Categories Requests------------------ */

    // 80’s movies request
    @GetMapping("/movies/80s")
    public MoviesByPeriod getMovies80s(){
        System.out.println(" ---> 80’s movies request from frontend");
        return movieDbApi.getMovies80s(api_key, lang, include_video,"1980-01-01", "1989-12-31" ,with_original_language );
    }

    // 90’s movies request
    @GetMapping("/movies/90s")
    public MoviesByPeriod getMovies90s(){
        System.out.println(" ---> 90’s movies request from frontend");
        return movieDbApi.getMovies90s(api_key, lang, include_video, "1990-01-01", "1999-12-31" ,with_original_language );
    }

    // 00’s movies request
    @GetMapping("/movies/00s")
    public MoviesByPeriod getMovies00s(){
        System.out.println(" ---> 00’s movies request from frontend");
        return movieDbApi.getMovies00s(api_key, lang, include_video,"2000-01-01", "2019-12-31" ,with_original_language);
    }


    // Disney movies request
    @GetMapping("/movies/disney")
    public MoviesByPeriod getMoviesDisney(){
        System.out.println(" ---> Disney movies request from frontend");
        return movieDbApi.getMoviesDisney(api_key, lang, include_video,"134209", with_original_language);
    }

    // Movies with actor / actress



    /* ------------------Search Request------------------ */

    // Search movie request from frontend
    @GetMapping("/search/{query}")
    public SearchResults getSearchResult(@PathVariable String query){
        System.out.println(" ---> Search request from frontend");
        return movieDbApi.getSearchResult(api_key, lang, query);
    }

    // Search company request from frontend
    @GetMapping("/search/company/{query}")
    public SearchResults getSearchCompanyResults(@PathVariable String query){ //update return type!
        System.out.println(" ---> Search company request from frontend");
        return movieDbApi.getSearchCompanyResults(api_key, query);
    }




}
