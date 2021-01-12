package netflixclone.NetflixAssignment.feignclient;


import netflixclone.NetflixAssignment.view.searchResults.SearchResults;
import netflixclone.NetflixAssignment.view.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.view.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.view.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.view.moviesTopRated.MoviesTopRated;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(url="https://api.themoviedb.org/3/",name = "MovieDataBaseClientApi")
public interface MovieDbApi {

    //Top rated movies
    @GetMapping("movie/top_rated")
    public MoviesTopRated getTopRatedMovies(@RequestParam(value="api_key") String api_key, @RequestParam(value="language") String language, @RequestParam(value="page") String pageNr);


    // Movie genres overview
    @GetMapping("genre/movie/list")
    public MovieGenres getMovieGenres(@RequestParam(value="api_key") String api_key, @RequestParam(value="language") String language);


    // Single movie details request
    @GetMapping("movie/{movieId}")
    public MovieDetails getMovieDetails(@PathVariable("movieId") String movieId, @RequestParam(value="api_key") String api_key, @RequestParam(value="language") String language);


    //Movie by genre request
    @GetMapping("discover/movie")
    MoviesByGenre getMoviesByGenre(@RequestParam(value="api_key") String api_key, @RequestParam(value="with_genres") String genreId);


    //https://api.themoviedb.org/3/search/multi?api_key=4b9e0a6d10b150a86ea776f903aaaf8c&language=en-US&query=brad%20pitt&page=1&include_adult=false
    // Multi search request
    @GetMapping("search/multi")
    public SearchResults getSearchResult(@RequestParam(value="api_key") String api_key, @RequestParam(value="language") String language, @RequestParam("query") String query);


}

