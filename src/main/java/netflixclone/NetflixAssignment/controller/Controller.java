package netflixclone.NetflixAssignment.controller;


import netflixclone.NetflixAssignment.feignclient.FanArtApi;
import netflixclone.NetflixAssignment.feignclient.MovieDbApi;

import netflixclone.NetflixAssignment.model.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.model.movieImagesFA.MovieImagesFA;
import netflixclone.NetflixAssignment.model.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.model.moviesUpcoming.MoviesUpcoming;
import netflixclone.NetflixAssignment.model.searchResults.SearchResults;

import netflixclone.NetflixAssignment.model.searchResults.searchPeopleView.SearchPeople;
import netflixclone.NetflixAssignment.service.MovieService;

import netflixclone.NetflixAssignment.view.movieDetailsView.MovieDetailsView;
import netflixclone.NetflixAssignment.view.movieImagesFaView.MovieLogos;
import netflixclone.NetflixAssignment.view.movieImagesFaView.MovieLogosView;
import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;

import netflixclone.NetflixAssignment.view.moviesByGenreView.ResultMBG;
import netflixclone.NetflixAssignment.view.searchResultsView.SearchActorResult;
import netflixclone.NetflixAssignment.view.searchResultsView.searchActorMovieList.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class  Controller {



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

    // test fallback
    @GetMapping("/movie/img/{id}")
    public MovieImagesFA getMovieImg(@PathVariable int id){
        System.out.println(" ---> Movie images requested from frontend");
        return fanArtApi.getMovieImg(000 , "123");
    }


    // Get images from FanArt
    @GetMapping("/movie/images/{id}")
    public MovieImagesFA getMovieImages(@PathVariable int id){
        System.out.println(" ---> Movie images requested from frontend");
        return movieService.getMovieImages(id);
    }

    // Get images from FanArt
    @GetMapping("/movie/logos/{id}")
    public List<MovieLogos>  getMovieLogos(@PathVariable int id){
        System.out.println(" ---> Movie images requested from frontend");
        return movieService.getMovieLogo(id);
    }


    // Upcoming movies request from frontend
    @GetMapping("movies/upcoming/{pageNr}")
    public MoviesUpcoming getUpcomingMovies(@PathVariable String pageNr) {
        System.out.println(" ---> Movies Upcoming requested from frontend and pageNr = " + pageNr);
        return movieService.getMoviesUpcoming(pageNr);
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
    public List<ResultMBG> getMoviesByGenre40(@PathVariable String genreId){
        System.out.println(" ---> Movies genre with id:"+ genreId +" requested from frontend");
        return movieService.getMoviesByGenreList(genreId, false,false, false);
    }


    /* ------------------Categories Requests------------------ */

    // 80’s movies request
    @GetMapping("/movies/80s")
    public List<ResultMBG> getMovies80s(){
        System.out.println(" ---> 80’s movies request from frontend");
        return movieService.getMovies80s();
    }

    // 90’s movies request
    @GetMapping("/movies/90s")
    public List<ResultMBG> getMovies90s(){
        System.out.println(" ---> 90’s movies request from frontend");
        return movieService.getMovies90s();
    }

    // 00’s movies request
    @GetMapping("/movies/00s")
    public List<ResultMBG> getMovies00s(){
        System.out.println(" ---> 00’s movies request from frontend");
        return movieService.getMovies00s();
    }

    // Movies with actor / actress
    @GetMapping("/movies/actor/{actorId}")
    public List<ResultMBG> getMoviesByActor(@PathVariable String actorId){
        System.out.println(" ---> Movies with actorId:"+ actorId +" request from frontend");
        return movieService.getMoviesByActor(actorId);
    }

    // Movies with company
    @GetMapping("/movies/company/{companyId}")
    public List<ResultMBG> getMoviesCompany(@PathVariable String companyId){
        System.out.println(" ---> Company with id:"+ companyId +" request from the front end");
        return movieService.getMoviesCompany(companyId);
    }



    /* ------------------Search Request------------------ */

    // Search movie request from frontend
    @GetMapping("/search/movie/{query}")
    public SearchResults getMovieSearchResults(@PathVariable String query){
        System.out.println(" ---> Search movie request from frontend");
        return movieService.getMovieSearchResults(query);
    }


    // Search suggestions actor request from frontend
    @GetMapping("/search/actors/sug/{query}")
    public List<Actor> getActorsSearchResultsSuggestions(@PathVariable String query){
        System.out.println(" ---> Search suggestions actor request from frontend");
        return movieService.getActorsSearchResultsListSuggestion(query);
    }

    // Search suggestions actor request from frontend
    @GetMapping("/search/actor/{query}")
    public SearchPeople getActorsSearchResultsQuery(@PathVariable String query){
        System.out.println(" ---> Search actor request from frontend");
        return  movieService.getActorSearchResultsQuery(query);
    }

    // Search actor query request from frontend
    @GetMapping("/search/actors/{query}")
    public SearchActorResult  getActorsSearchResults(@PathVariable String query){
        System.out.println(" ---> Search actor query request from frontend");
        List<Actor> newList = movieService.getActorsSearchResultsList(query);
        SearchActorResult newResults = new SearchActorResult ();
        newResults.setResults(newList);

        return newResults;
    }



    // Search company request from frontend
    @GetMapping("/search/company/{query}") // company ID (number) is required here
    public SearchResults getSearchCompanyResults(@PathVariable String query){ //update return type!
        System.out.println(" ---> Search company request from frontend");
        return movieService.getSearchCompanyResults(query);
    }



}
