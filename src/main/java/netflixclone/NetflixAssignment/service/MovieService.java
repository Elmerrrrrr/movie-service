package netflixclone.NetflixAssignment.service;

import netflixclone.NetflixAssignment.model.movieTrailer.MovieTrailer;
import netflixclone.NetflixAssignment.model.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.view.movieTrailerView.MovieTrailerView;
import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;
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






    public MoviesByGenreView getMoviesByGenre(String api_key, String genreId) {

        MoviesByGenre dtoObject = movieDbApi.getMoviesByGenre(api_key, genreId);


        MoviesByGenreView viewObject = new MoviesByGenreView();
        List<Result> newList = new ArrayList<>();
        viewObject.setPage(dtoObject.getPage());
        viewObject.setTotalPages(dtoObject.getTotalPages());
        viewObject.setTotalResults(dtoObject.getTotalResults());

        for (int i = 0; i<dtoObject.getResults().size(); i++) {

            Result result = new Result();
            result.setId(dtoObject.getResults().get(i).getId());
            result.setTitle(dtoObject.getResults().get(i).getTitle());
            result.setOriginalTitle(dtoObject.getResults().get(i).getOriginalTitle());
            result.setOverview(dtoObject.getResults().get(i).getOverview());
            result.setReleaseDate(dtoObject.getResults().get(i).getReleaseDate());
            result.setOriginalLanguage(dtoObject.getResults().get(i).getOriginalLanguage());
            result.setBackdropPath(dtoObject.getResults().get(i).getBackdropPath());
            result.setPosterPath(dtoObject.getResults().get(i).getPosterPath());

            //add trailer info
            int movieId = dtoObject.getResults().get(i).getId();
            MovieTrailer dtoTrailer = movieDbApi.getMovieTrailer(movieId,api_key,lang);
            MovieTrailerView trailerView = new MovieTrailerView();

            for (int j=0; j<dtoTrailer.getResults().size(); j++){
                trailerView.setYoutubeId(dtoTrailer.getResults().get(j).getKey());
            }
            result.setTrailer(trailerView.getYoutubeId());


            //add result object to the ArrayList
            newList.add(result);
        }

        viewObject.setResults(newList);
        return viewObject;
    }



}
