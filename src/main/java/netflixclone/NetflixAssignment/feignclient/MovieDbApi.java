package netflixclone.NetflixAssignment.feignclient;


import netflixclone.NetflixAssignment.feignclient.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.feignclient.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.feignclient.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.feignclient.moviesTopRated.MoviesTopRated;
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
    public MoviesByGenre getMoviesByGenre(@RequestParam(value="api_key") String api_key, @RequestParam(value="with_genres") String genreId);

}

