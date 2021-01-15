package netflixclone.NetflixAssignment.feignclient;


import netflixclone.NetflixAssignment.dto.moviesBannerIntro.BannerIntroMovies;
import netflixclone.NetflixAssignment.dto.moviesByPeriod.MoviesByPeriod;
import netflixclone.NetflixAssignment.dto.searchResults.SearchResults;
import netflixclone.NetflixAssignment.dto.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.dto.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.dto.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.dto.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(url="https://api.themoviedb.org/3/",name = "MovieDataBaseClientApi")
public interface MovieDbApi {



    //Top rated movies
    @GetMapping("movie/top_rated")
    MoviesTopRated getTopRatedMovies(@RequestParam(value="api_key") String api_key,
                                     @RequestParam(value="language") String language,
                                     @RequestParam(value="page") String pageNr);



    /* ------------------Movies Requests------------------ */

    // Single movie details request
    @GetMapping("movie/{movieId}")
    MovieDetails getMovieDetails(@PathVariable("movieId") String movieId,
                                 @RequestParam(value="api_key") String api_key,
                                 @RequestParam(value="language") String language,
                                 @RequestParam(value="video") String inclVideo);

    // Intro banner request
    @GetMapping("discover/tv")
    BannerIntroMovies getBannerIntroMovie(@RequestParam(value="api_key") String api_key,
                                          @RequestParam(value="language") String language,
                                          @RequestParam(value="include_video") String inclVideo,
                                          @RequestParam(value="with_networks") String networks);



    /* ------------------Genre Requests------------------ */

    // Movie genres overview
    @GetMapping("genre/movie/list")
    MovieGenres getMovieGenres(@RequestParam(value="api_key") String api_key,
                               @RequestParam(value="language") String language);


    //Movie by genre request
    @GetMapping("discover/movie")
    MoviesByGenre getMoviesByGenre(@RequestParam(value="api_key") String api_key,
                                       @RequestParam(value="with_genres") String genreId
                                     //  @RequestParam(value="language") String language,
                                     //  @RequestParam(value="include_video") String inclVideo,
                                      // @RequestParam(value="with_original_language") String original_language
                                       );



    /* ------------------Categories Requests------------------ */

   //80’s movies request
   @GetMapping("/discover/movie")
  MoviesByPeriod getMovies80s(@RequestParam(value="api_key") String api_key,
                              @RequestParam(value="language") String language,
                              @RequestParam(value="include_video") String inclVideo,
                              @RequestParam(value="primary_release_date.gte") String gteDate,
                              @RequestParam(value="primary_release_date.lte") String lteDate,
                              @RequestParam(value="with_original_language") String original_language);

    //90’s movies request
    @GetMapping("/discover/movie")
    MoviesByPeriod getMovies90s(@RequestParam(value="api_key") String api_key,
                                @RequestParam(value="language") String language,
                                @RequestParam(value="include_video") String inclVideo,
                                @RequestParam(value="primary_release_date.gte") String gteDate,
                                @RequestParam(value="primary_release_date.lte") String lteDate,
                                @RequestParam(value="with_original_language") String original_language);
    //00’s movies request
    @GetMapping("/discover/movie")
    MoviesByPeriod getMovies00s(@RequestParam(value="api_key") String api_key,
                                @RequestParam(value="language") String language,
                                @RequestParam(value="include_video") String inclVideo,
                                @RequestParam(value="primary_release_date.gte") String gteDate,
                                @RequestParam(value="primary_release_date.lte") String lteDate,
                                @RequestParam(value="with_original_language") String original_language);

    //Disney movies request
    @GetMapping("/discover/movie")
    MoviesByPeriod getMoviesDisney(@RequestParam(value="api_key") String api_key,
                                   @RequestParam(value="language") String language,
                                  // @RequestParam(value="include_video") String inclVideo,
                                   @RequestParam(value="with_companies") String withCompanies
                                  // @RequestParam(value="with_original_language") String original_language
                                    );


    // Movies with actor / actress
    @GetMapping("/discover/movie")
    MoviesByPeriod getMoviesByActor(@RequestParam(value="api_key") String api_key,
                                   @RequestParam(value="language") String language,
                                   @RequestParam(value="with_cast") String cast);




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





