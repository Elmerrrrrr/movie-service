package netflixclone.NetflixAssignment.service;

import netflixclone.NetflixAssignment.dto.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.dto.moviesBannerIntro.BannerIntroMovies;
import netflixclone.NetflixAssignment.dto.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.dto.moviesByPeriod.MoviesByPeriod;
import netflixclone.NetflixAssignment.dto.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.dto.searchResults.SearchResults;
import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;
import netflixclone.NetflixAssignment.view.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.feignclient.MovieDbApi;
import netflixclone.NetflixAssignment.view.moviesByGenreView.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {


    private final String lang = "en-US";
    private final String include_adult = "false";
    private final String with_original_language = "en";
    private final String include_video = "true";



    //The business logic for filtering and sorting

    @Value("${tmdb.api_key}")
    private String api_key;


    private final MovieDbApi movieDbApi;

    // Injecting Interface Feign Class
    @Autowired
    public MovieService(MovieDbApi movieDbApi) {
        this.movieDbApi = movieDbApi;
    }








    //-----------------------------------------------------------------------------------------------





    public  MoviesByGenreView getMoviesByGenre(String api_key, String genreId) {

        MoviesByGenre dtoObject = movieDbApi.getMoviesByGenre(api_key, genreId);

        MoviesByGenreView viewObject = new MoviesByGenreView();
        Result result =new Result();
        result.setOriginalTitle(dtoObject.getResults().get(0).getOriginalTitle());
        List<Result> newList = new ArrayList<>();
        newList.add(result);
        viewObject.setResults(newList);

        return viewObject;

    }

    //-----------------------------------------------------------------------------------------------






}
