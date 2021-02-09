package netflixclone.NetflixAssignment.controller;


import netflixclone.NetflixAssignment.feignclient.FanArtApi;
import netflixclone.NetflixAssignment.feignclient.MovieDbApi;

import netflixclone.NetflixAssignment.model.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.model.movieImagesFA.MovieImagesFA;
import netflixclone.NetflixAssignment.model.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.model.moviesByPeriod.MoviesByPeriod;
import netflixclone.NetflixAssignment.model.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.model.moviesUpcoming.MoviesUpcoming;
import netflixclone.NetflixAssignment.model.searchResults.SearchResults;

import netflixclone.NetflixAssignment.service.MovieService;

import netflixclone.NetflixAssignment.view.movieDetailsView.MovieDetailsView;
import netflixclone.NetflixAssignment.view.movieImagesFaView.MovieLogosView;
import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;

import netflixclone.NetflixAssignment.view.moviesByGenreView.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    // Get images from FanArt
    @GetMapping("/movie/logos/{id}")
    public MovieLogosView getMovieLogos(@PathVariable int id){
        System.out.println(" ---> Movie images requested from frontend");
        return movieService.getMovieLogo(id);
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


    // Get random movie request from frontend
    @GetMapping("/movie/random")
    public MovieDetailsView getRandomMovie(){
        System.out.println(" ---> Random top movie requested from frontend");
        return movieService.getRandomBannerMovie();
    }



    /* ------------------Genre Requests------------------ */

    // Genre-types movie request from frontend
    @GetMapping("/movies/genres")
    public MovieGenres getMovieGenres(){
        System.out.println(" ---> Movies genre requested from frontend");
        return movieService.getMovieGenres();
    }


    // Movies by genre request from frontend
    @GetMapping("/movies/genre/{genreId}/{pageNr}")
    public MoviesByGenreView getMoviesByGenre(@PathVariable String genreId, @PathVariable String pageNr){
        System.out.println(" ---> Movies genre with id:"+ genreId +"with pageNr: " + pageNr +" requested from frontend");
        return movieService.getMoviesByGenre(genreId, pageNr, false,false, false);
    }

    // Movies by genre request from frontend
    @GetMapping("/movies/genre/{genreId}")
    public List<Result> getMoviesByGenre40(@PathVariable String genreId){
        System.out.println(" ---> Movies genre with id:"+ genreId +" requested from frontend");
        return movieService.getMoviesByGenreList(genreId, false,false, false);
    }


    /* ------------------Categories Requests------------------ */

    // 80’s movies request
    @GetMapping("/movies/80s")
    public List<Result> getMovies80s(){
        System.out.println(" ---> 80’s movies request from frontend");
        return movieService.getMovies80s();
    }

    // 90’s movies request
    @GetMapping("/movies/90s")
    public List<Result> getMovies90s(){
        System.out.println(" ---> 90’s movies request from frontend");
        return movieService.getMovies90s();
    }

    // 00’s movies request
    @GetMapping("/movies/00s")
    public List<Result> getMovies00s(){
        System.out.println(" ---> 00’s movies request from frontend");
        return movieService.getMovies00s();
    }

    // Movies with actor / actress
    @GetMapping("/movies/actor/{actorId}")
    public List<Result> getMoviesByActor(@PathVariable String actorId){
        System.out.println(" ---> Movies with actorId:"+ actorId +" request from frontend");
        return movieService.getMoviesByActor(actorId);
    }

    // Movies with company
    @GetMapping("/movies/company/{companyId}")
    public List<Result> getMoviesCompany(@PathVariable String companyId){
        System.out.println(" ---> Company with id:"+ companyId +" request from the front end");
        return movieService.getMoviesCompany(companyId);
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
