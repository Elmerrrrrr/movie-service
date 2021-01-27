package netflixclone.NetflixAssignment.controller;


import netflixclone.NetflixAssignment.feignclient.FanArtApi;
import netflixclone.NetflixAssignment.feignclient.MovieDbApi;
import netflixclone.NetflixAssignment.model.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.model.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.model.movieImagesFA.MovieImagesFA;
import netflixclone.NetflixAssignment.model.moviesBannerIntro.BannerIntroMovies;
import netflixclone.NetflixAssignment.model.moviesByPeriod.MoviesByPeriod;
import netflixclone.NetflixAssignment.model.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.model.moviesUpcoming.MoviesUpcoming;
import netflixclone.NetflixAssignment.model.searchResults.SearchResults;
import netflixclone.NetflixAssignment.service.MovieService;
import netflixclone.NetflixAssignment.view.movieDetailsView.MovieDetailsView;
import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {



    @Value("${tmdb.api_key}")
    private String api_key;

    @Value("${fnrt.api_key}")
    private String api_keyFA;


    // Injecting Interface Feign Classes
    @Autowired
    private MovieService movieService;

    @Autowired
    private FanArtApi fanArtApi;

    @Autowired
    private MovieDbApi movieDbApi;



    // Get images from FanArt
    @GetMapping("/movie/images/{id}")
    public MovieImagesFA getMovieImages(@PathVariable int id){
        System.out.println(" ---> Movie images requested from frontend");
        return movieService.getMovieImages(id);
    }

    // Upcoming movies request from frontend
    @GetMapping("movies/upcoming/{pageNr}")
    public MoviesUpcoming getUpcomingMovies(@PathVariable String pageNr) {
        System.out.println(" ---> Movies Upcoming requested from frontend and pageNr = " + pageNr);
        return movieDbApi.getMoviesUpcoming("4b9e0a6d10b150a86ea776f903aaaf8c", "en-US", pageNr);
    }


    // Top Rated movie request from frontend
    @GetMapping("/movies/toprated/{pageNr}")
    public MoviesTopRated getTopRatedMovies(@PathVariable String pageNr){
        System.out.println(" ---> Movies TopRated requested from frontend");
        return movieService.getTopRatedMovies(pageNr);
    }


    // Single movie detail request from frontend
    @GetMapping("/movie/details/{movieId}")
    public MovieDetailsView getMovieDetails(@PathVariable int movieId){
        System.out.println(" ---> Movie details with id:"+ movieId +" requested from frontend");
        return movieService.getMovieDetails(movieId);
    }








    // Get introBanner movie request from frontend
    @GetMapping("/movies/introBanner")
    public BannerIntroMovies getBannerIntroMovie(){
        System.out.println(" ---> Intro banner movie request from frontend");
        return movieService.getBannerIntroMovie("213");
    }


    /* ------------------Genre Requests------------------ */

    // Genre-types movie request from frontend
    @GetMapping("/movies/genres")
    public MovieGenres getMovieGenres(){
        System.out.println(" ---> Movies genre requested from frontend");
        return movieService.getMovieGenres();
    }


    // Movies by genre request from frontend
    @GetMapping("/movies/genre/{genreId}")
    public MoviesByGenreView getMoviesByGenre(@PathVariable String genreId){

        System.out.println(" ---> Movies genre with id:"+ genreId +" requested from frontend");

        return movieService.getMoviesByGenre(genreId);
    }



    /* ------------------Categories Requests------------------ */

    // 80’s movies request
    @GetMapping("/movies/80s")
    public MoviesByPeriod getMovies80s(){
        System.out.println(" ---> 80’s movies request from frontend");
        return movieService.getMovies80s();
    }

    // 90’s movies request
    @GetMapping("/movies/90s")
    public MoviesByPeriod getMovies90s(){
        System.out.println(" ---> 90’s movies request from frontend");
        return movieService.getMovies90s();
    }

    // 00’s movies request
    @GetMapping("/movies/00s")
    public MoviesByPeriod getMovies00s(){
        System.out.println(" ---> 00’s movies request from frontend");
        return movieService.getMovies00s();
    }


    // Disney movies request
    @GetMapping("/movies/company/{companyId}")
    public MoviesByPeriod getMoviesDisney(@PathVariable String companyId){
        System.out.println(" ---> Disney movies request from frontend");
        return movieService.getMoviesCompany(companyId);// 134209 for disney?
    }


    // Movies with actor / actress
    @GetMapping("/movies/{actorId}}")
    public MoviesByPeriod getMoviesByActor(@PathVariable String actorId){
        System.out.println(" ---> 00’s movies request from frontend");
        return movieService.getMoviesByActor(actorId);
    }




    /* ------------------Search Request------------------ */

    // Search movie request from frontend
    @GetMapping("/search/{query}")
    public SearchResults getSearchResult(@PathVariable String query){
        System.out.println(" ---> Search request from frontend");
        return movieService.getSearchResult(query);
    }

    // Search company request from frontend
    @GetMapping("/search/company/{query}") // company ID (number) is required here
    public SearchResults getSearchCompanyResults(@PathVariable String query){ //update return type!
        System.out.println(" ---> Search company request from frontend");
        return movieService.getSearchCompanyResults(query);
    }





}
