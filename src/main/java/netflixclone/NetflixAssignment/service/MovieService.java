package netflixclone.NetflixAssignment.service;

import netflixclone.NetflixAssignment.dto.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.dto.moviesBannerIntro.BannerIntroMovies;
import netflixclone.NetflixAssignment.dto.moviesByPeriod.MoviesByPeriod;
import netflixclone.NetflixAssignment.dto.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.dto.searchResults.SearchResults;
import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;
import netflixclone.NetflixAssignment.view.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.feignclient.MovieDbApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class MovieService implements MovieDbApi{


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


    @Override
    public MoviesTopRated getTopRatedMovies(String api_key, String language, String pageNr) {
        return null;
    }

    @Override
    public MovieGenres getMovieGenres(String api_key, String language) {
        return null;
    }



    //-----------------------------------------------------------------------------------------------

    @Override
    public MoviesByGenreView getMoviesByGenre(String api_key, String genreId, String language, String inclVideo, String original_language) {
        return null;
    }


//    @Override
//    public MoviesByGenreView getMoviesByGenre(String api_key, String genreId, String language, String inclVideo, String original_language) {
//
//        MoviesByGenreView moviesByGenreViewInstance = movieDbApi.getMoviesByGenre(api_key, genreId, lang,include_video, with_original_language);
//
//        moviesByGenreViewInstance.getResults();
//
//        return moviesByGenreViewInstance;
//
//    }

    //-----------------------------------------------------------------------------------------------



    @Override
    public netflixclone.NetflixAssignment.dto.movieDetails.MovieDetails getMovieDetails(String movieId, String api_key, String language, String inclVideo) {
        return null;
    }

    @Override
    public BannerIntroMovies getBannerIntroMovie(String api_key, String language, String inclVideo, String networks) {
        return null;
    }


    @Override
    public MoviesByPeriod getMovies80s(String api_key, String language, String inclVideo, String gteDate, String lteDate, String original_language) {
        return null;
    }

    @Override
    public MoviesByPeriod getMovies90s(String api_key, String language, String inclVideo, String gteDate, String lteDate, String original_language) {
        return null;
    }

    @Override
    public MoviesByPeriod getMovies00s(String api_key, String language, String inclVideo, String gteDate, String lteDate, String original_language) {
        return null;
    }

    @Override
    public MoviesByPeriod getMoviesDisney(String api_key, String language, String withCompanies) {
        return null;
    }

    @Override
    public MoviesByPeriod getMoviesByActor(String api_key, String language, String inclVideo) {
        return null;
    }

    @Override
    public SearchResults getSearchResult(String api_key, String language, String query) {
        return null;
    }

    @Override
    public SearchResults getSearchCompanyResults(String api_key, String query) {
        return null;
    }





}
