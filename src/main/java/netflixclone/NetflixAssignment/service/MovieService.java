package netflixclone.NetflixAssignment.service;

import netflixclone.NetflixAssignment.view.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.view.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.view.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.view.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.feignclient.MovieDbApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class MovieService {


    //The business logic for filtering and sorting

    @Value("${tmdb.api_key}")
    private String api_key;


    private final MovieDbApi movieDbApi;

    // Injecting Interface Feign Class
    @Autowired
    public MovieService(MovieDbApi movieDbApi) {
        this.movieDbApi = movieDbApi;
    }




    public MoviesTopRated getTopRatedMovies(String api_key, String language, String pageNr) {
        return null;
    }


    public MovieGenres getMovieGenres(String api_key, String language) {
        return null;
    }


    public MovieDetails getMovieDetails(String movieId, String api_key, String language) {
        return null;
    }

//
//    public MoviesByGenre getMoviesByGenre(String api_key, String genreId) {
//        MoviesByGenre x = new MoviesByGenre();
//        x.setName
//        return movieDbApi.getMoviesByGenre(api_key, genreId);
//    }
//

}
