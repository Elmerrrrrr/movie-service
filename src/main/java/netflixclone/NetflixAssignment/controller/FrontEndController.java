package netflixclone.NetflixAssignment.controller;

import netflixclone.NetflixAssignment.feignclient.FanArtApi;
import netflixclone.NetflixAssignment.model.movieImagesFA.MovieImagesFA;
import netflixclone.NetflixAssignment.model.moviesBannerIntro.BannerIntroMovies;
import netflixclone.NetflixAssignment.model.moviesByPeriod.MoviesByPeriod;
import netflixclone.NetflixAssignment.feignclient.MovieDbApi;
import netflixclone.NetflixAssignment.model.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.model.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.model.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.service.MovieService;
import netflixclone.NetflixAssignment.model.searchResults.SearchResults;
import netflixclone.NetflixAssignment.view.movieDetailsView.MovieDetailsView;
import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
public class FrontEndController {

    private final String lang = "en-US";
    private final String include_adult = "false";
    private final String with_original_language = "en";
    private final String include_video = "true";


    @Value("${tmdb.api_key}")
    private String api_key;

    @Value("${fnrt.api_key}")
    private String api_keyFA;


    // Injecting Interface Feign Class
    @Autowired
    private MovieDbApi movieDbApi;

    @Autowired
    private MovieService movieService;

    @Autowired
    private FanArtApi fanArtApi;




    //Get images from FanArt
    @GetMapping("/movie/images/{id}")
    public MovieImagesFA getMovieImages(@PathVariable int id){
        System.out.println(" ---> Movie images requested from frontend");
        return fanArtApi.getMovieImages(id, api_keyFA);
    }


    // Top Rated movie request from frontend
    @GetMapping("/movies/toprated/{pageNr}")
    public MoviesTopRated getTopRatedMovies(@PathVariable String pageNr){
        System.out.println(" ---> Movies TopRated requested from frontend");
        return movieDbApi.getTopRatedMovies(api_key, lang, pageNr);
    }



    // Single movie detail request from frontend
     @GetMapping("/movie/detailss/{movieId}")
     public MovieDetails getMovieDetailss(@PathVariable int movieId){
         System.out.println(" ---> Movie detailss with id:"+ movieId +" requested from frontend");
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


//    // Movies by genre request from frontend
//    @GetMapping("/movies/genree/{genreId}")
//    public MoviesByGenreView getMoviesByGenree(@PathVariable String genreId){
//        System.out.println(" ---> Movies genre with id:"+ genreId +" requested from frontend");
////        MoviesByGenre newMoviesByGenre = new MoviesByGenre();
////        newMoviesByGenre.getResults();
//        return movieDbApi.getMoviesByGenre(api_key, genreId);
//    }


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
        return movieDbApi.getMoviesCompany(api_key, lang, "134209");
    }


    // Movies with actor / actress
    @GetMapping("/movies/{actorId}}")
    public MoviesByPeriod getMoviesByActor(@PathVariable String actorId){
        System.out.println(" ---> 00’s movies request from frontend");
        return movieDbApi.getMoviesByActor(api_key, lang, actorId);
    }





    /* ------------------Search Request------------------ */

    // Search movie request from frontend
    @GetMapping("/search/{query}")
    public SearchResults getSearchResult(@PathVariable String query){
        System.out.println(" ---> Search request from frontend");
        return movieDbApi.getSearchResult(api_key, lang, query);
    }

    // Search company request from frontend
    @GetMapping("/search/company/{query}") // company ID (number) is required here
    public SearchResults getSearchCompanyResults(@PathVariable String query){ //update return type!
        System.out.println(" ---> Search company request from frontend");
        return movieDbApi.getSearchCompanyResults(api_key, query);
    }




}
