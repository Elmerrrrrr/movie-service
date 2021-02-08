package netflixclone.NetflixAssignment.feignclient;


import netflixclone.NetflixAssignment.model.movieTrailer.MovieTrailer;
import netflixclone.NetflixAssignment.model.moviesByPeriod.MoviesByPeriod;
import netflixclone.NetflixAssignment.model.moviesUpcoming.MoviesUpcoming;
import netflixclone.NetflixAssignment.model.searchResults.SearchResults;
import netflixclone.NetflixAssignment.model.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.model.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.model.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.model.moviesTopRated.MoviesTopRated;

import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(url="https://api.themoviedb.org/3/",name = "MovieDataBaseClientApi")
public interface MovieDbApi {

    //Upcoming movies
    @GetMapping("movie/upcoming")
    MoviesUpcoming getMoviesUpcoming(@RequestParam(value="api_key") String api_key,
                                     @RequestParam(value="language") String language,
                                     @RequestParam(value="page") String pageNr);

    //Top rated movies
    @GetMapping("movie/top_rated")
    MoviesTopRated getTopRatedMovies(@RequestParam(value="api_key") String api_key,
                                     @RequestParam(value="language") String language,
                                     @RequestParam(value="with_original_language") String originalLanguage,
                                     @RequestParam(value="page") String pageNr);

   // Movie trailer request
    @GetMapping("movie/{movieId}/videos")
    MovieTrailer getMovieTrailer(@PathVariable("movieId") int movieId,
                                 @RequestParam(value="api_key") String api_key,
                                 @RequestParam(value="language") String language);



    /* ------------------Movies Requests------------------ */

    // Single movie details request
    @GetMapping("movie/{movieId}")
    MovieDetails getMovieDetails(@PathVariable("movieId") int movieId,
                                 @RequestParam(value="api_key") String api_key,
                                 @RequestParam(value="language") String language,
                                 @RequestParam(value="video") String inclVideo,
                                 @RequestParam(value="append_to_response") String credits
                                 );


    /* ------------------Genre Requests------------------ */

    // Movie genres overview
    @GetMapping("genre/movie/list")
    MovieGenres getMovieGenres(@RequestParam(value="api_key") String api_key,
                               @RequestParam(value="language") String language);


    //Movie by genre request
    @GetMapping("discover/movie")
    MoviesByGenre getMoviesByGenre(@RequestParam(value="api_key") String api_key,
                                   @RequestParam(value="with_genres") String genreId,
                                   @RequestParam(value="page") String pageNr
                                   );



    /* ------------------Categories Requests------------------ */

   //categories movies request
   @GetMapping("/discover/movie")
   MoviesByGenre getMoviesCategories(@RequestParam(value="api_key") String api_key,
                                         @RequestParam(value="language") String language,
                                         @RequestParam(value="primary_release_date.gte") String gteDate,
                                         @RequestParam(value="primary_release_date.lte") String lteDate,
                                         @RequestParam(value="with_original_language") String original_language,
                                         @RequestParam(value="page") String pageNr
                                        );


    // Movies with actor / actress
    @GetMapping("/discover/movie")
    MoviesByGenre getMoviesByActor(@RequestParam(value="api_key") String api_key,
                                   @RequestParam(value="language") String language,
                                   @RequestParam(value="with_cast") String cast);

    // Movies with companies
    @GetMapping("/discover/movie")
    MoviesByGenre getMoviesByCompany(@RequestParam(value="api_key") String api_key,
                                    @RequestParam(value="language") String language,
                                    @RequestParam(value="with_companies") String company);




    /* ------------------Search Request------------------ */

    // Multi search request
    @GetMapping("search/multi")
    SearchResults getSearchResult(@RequestParam(value="api_key") String api_key,
                                  @RequestParam(value="language") String language,
                                  @RequestParam("query") String query);

    //Company search request
    @GetMapping("search/company")
    SearchResults getSearchCompanyResults(@RequestParam(value="api_key") String api_key,
                                          @RequestParam("query") String companyId);



}





