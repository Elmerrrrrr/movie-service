package netflixclone.NetflixAssignment.service;

import netflixclone.NetflixAssignment.feignclient.FanArtApi;
import netflixclone.NetflixAssignment.feignclient.MovieDbApi;

// imports from model
import netflixclone.NetflixAssignment.model.movieDetails.Cast;
import netflixclone.NetflixAssignment.model.movieDetails.MovieDetails;

import netflixclone.NetflixAssignment.model.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.model.movieImagesFA.MovieImagesFA;
import netflixclone.NetflixAssignment.model.movieTrailer.MovieTrailer;
import netflixclone.NetflixAssignment.model.moviesBannerIntro.BannerIntroMovies;
import netflixclone.NetflixAssignment.model.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.model.moviesByPeriod.MoviesByPeriod;
import netflixclone.NetflixAssignment.model.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.model.searchResults.SearchResults;

// imports from view
import netflixclone.NetflixAssignment.view.movieDetailsView.Genre;
import netflixclone.NetflixAssignment.view.movieDetailsView.MovieDetailsView;
import netflixclone.NetflixAssignment.view.movieDetailsView.ProductionCompany;
import netflixclone.NetflixAssignment.view.movieTrailerView.MovieTrailerView;
import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;
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

    // credits is necessary to get the list of actors
    private final String append_to_response = "credits";
    // other one to add is with_companies, this retrieves a list made by the given company



    @Value("${tmdb.api_key}")
    private String api_keyMD;

    @Value("${fnrt.api_key}")
    private String api_keyFA;


    @Autowired
    private MovieDbApi movieDbApi;

    @Autowired
    private FanArtApi fanArtApi;



    public String getMovieTrailer(int movieId){

        MovieTrailer dtoTrailer = movieDbApi.getMovieTrailer(movieId,api_keyMD,lang);
        MovieTrailerView trailerView = new MovieTrailerView();
        for (int i=0; i<dtoTrailer.getResults().size(); i++){
            trailerView.setYoutubeId(dtoTrailer.getResults().get(i).getKey());
          }

        return trailerView.getYoutubeId();
    } //done


    public String getMovieLogo(int movieId){

        MovieImagesFA dtoImagesFA = fanArtApi.getMovieImages(movieId, api_keyFA);

        if (dtoImagesFA == null  || dtoImagesFA.getMovielogo() == null || dtoImagesFA.getMovielogo().size() == 0){
            return "";
        } else
            return dtoImagesFA.getMovielogo().get(0).getUrl();
    } //done


     public MovieImagesFA getMovieImages(int id) {

         return fanArtApi.getMovieImages(id, api_keyFA);
     } //done


    public MoviesTopRated getTopRatedMovies( String pageNr) {

        return movieDbApi.getTopRatedMovies(api_keyMD, lang, pageNr);
    } //done


    /* ------------------Single Movie Requests------------------ */
    public MovieDetailsView getMovieDetails(int movieId){

        MovieDetails dtoDetailsMovie = movieDbApi.getMovieDetails(movieId, api_keyMD, lang, include_video, append_to_response);
        MovieDetailsView detailsMovieView = new MovieDetailsView();

        detailsMovieView.setOriginalLanguage(dtoDetailsMovie.getOriginalLanguage());
        detailsMovieView.setReleaseDate(dtoDetailsMovie.getReleaseDate());
        detailsMovieView.setId(dtoDetailsMovie.getId());
        detailsMovieView.setTitle(dtoDetailsMovie.getTitle());
        detailsMovieView.setOverview(dtoDetailsMovie.getOverview());
        detailsMovieView.setPosterPath(dtoDetailsMovie.getPosterPath());
        detailsMovieView.setBackdropPath(dtoDetailsMovie.getBackdropPath());
        detailsMovieView.setReleaseDate(dtoDetailsMovie.getReleaseDate());
        detailsMovieView.setBudget(dtoDetailsMovie.getBudget());
        detailsMovieView.setBudget(dtoDetailsMovie.getBudget());
        detailsMovieView.setOriginalTitle(dtoDetailsMovie.getOriginalTitle());
        detailsMovieView.setHomepage(dtoDetailsMovie.getHomepage());
        detailsMovieView.setRevenue(dtoDetailsMovie.getRevenue());
        detailsMovieView.setRuntime(dtoDetailsMovie.getRuntime());
        detailsMovieView.setVoteAverage(dtoDetailsMovie.getVoteAverage());
        detailsMovieView.setVoteCount(dtoDetailsMovie.getVoteCount());

        // alright, so genre is an ArrayList, which we can fill
        List<Genre> newGenreList = new ArrayList<>();

        for (int i = 0; i < dtoDetailsMovie.getGenres().size(); i++) {

            Genre genresViewDetailList = new Genre();
            genresViewDetailList.setId(dtoDetailsMovie.getGenres().get(i).getId());
            genresViewDetailList.setName(dtoDetailsMovie.getGenres().get(i).getName());
            newGenreList.add(genresViewDetailList);

        }
        detailsMovieView.setGenres(newGenreList);



        // let us try and get the production companies as well
        List<ProductionCompany>  newProductionCompanyList = new ArrayList<>();
        for(int i = 0; i < dtoDetailsMovie.getProductionCompanies().size(); i++) {
            ProductionCompany productionViewDetailList = new ProductionCompany();
            productionViewDetailList.setId(dtoDetailsMovie.getProductionCompanies().get(i).getId());
            productionViewDetailList.setName(dtoDetailsMovie.getProductionCompanies().get(i).getName());
            productionViewDetailList.setLogoPath(dtoDetailsMovie.getProductionCompanies().get(i).getLogoPath());
            newProductionCompanyList.add(productionViewDetailList);
        }
        detailsMovieView.setProductionCompany(newProductionCompanyList);




        // the cast
        List<Cast> newCastList = new ArrayList<>();

        for (int i = 0; i < dtoDetailsMovie.getCredits().getCast().size(); i++) {

            Cast castViewDetailList = new Cast();
            castViewDetailList.setPopularity(dtoDetailsMovie.getCredits().getCast().get(i).getPopularity());
            castViewDetailList.setName(dtoDetailsMovie.getCredits().getCast().get(i).getName());
            castViewDetailList.setCharacter(dtoDetailsMovie.getCredits().getCast().get(i).getCharacter());
            newCastList.add(castViewDetailList);

        }
        // in de view staat de setCast method
        detailsMovieView.setCast(newCastList);


        // set director
        for (int i = 0; i <dtoDetailsMovie.getCredits().getCrew().size(); i++) {

            if (dtoDetailsMovie.getCredits().getCrew().get(i).job.equals("Director")) {
                detailsMovieView.setDirector(dtoDetailsMovie.getCredits().getCrew().get(i).getName());
            }
        }


        // add trailer info
        detailsMovieView.setTrailer(getMovieTrailer(movieId));
        // add logo if available
        detailsMovieView.setMovieLogoUrl(getMovieLogo(movieId));



        return detailsMovieView;
    } // done - finalized


    public BannerIntroMovies getBannerIntroMovie(String s) {
        // let this method return 1 random top movie
        // logo + trailer info
        return movieDbApi.getBannerIntroMovie(api_keyMD, lang, include_video, "213");
    } //done


    /* ------------------Genre Requests------------------ */

    public MovieGenres getMovieGenres() {
        return movieDbApi.getMovieGenres(api_keyMD, lang); //done
    }

    public MoviesByGenreView getMoviesByGenre(String genreId) {


        MoviesByGenre dtoObject = movieDbApi.getMoviesByGenre(api_keyMD, genreId);

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


            int movieId = dtoObject.getResults().get(i).getId();

            //add trailer info
            result.setTrailer(getMovieTrailer(movieId));
            result.setLogoPath(getMovieLogo(movieId));

            //add result object to the ArrayList
            newList.add(result);
        }

        viewObject.setResults(newList);
        return viewObject;
    } //done - finalized

    // may be here we try and get the companies by companyId
    // other thing to do is in a single movie search add the parameter with_companies



    /* ------------------Categories Requests------------------ */

    public MoviesByPeriod getMovies80s() {
        return movieDbApi.getMovies80s(api_keyMD, lang, include_video,"1980-01-01", "1989-12-31" ,with_original_language );
    }

    public MoviesByPeriod getMovies90s() {
        return movieDbApi.getMovies90s(api_keyMD, lang, include_video, "1990-01-01", "1999-12-31" ,with_original_language );
    }

    public MoviesByPeriod getMovies00s() {
        return movieDbApi.getMovies00s(api_keyMD, lang, include_video,"2000-01-01", "2019-12-31" ,with_original_language);
    }

    public MoviesByPeriod getMoviesByActor(String actorId) {
        return movieDbApi.getMoviesByActor(api_keyMD, lang, actorId);
    }

    public MoviesByPeriod getMoviesByCompany(String companyId) {
        return movieDbApi.getMoviesByCompany(api_keyMD, lang, companyId);
    }


    /* ------------------Search Request------------------ */

    public SearchResults getSearchResult(String query) {
        return movieDbApi.getSearchResult(api_keyMD, lang, query);
    }

    public SearchResults getSearchCompanyResults(String query) {
        return movieDbApi.getSearchCompanyResults(api_keyMD, query);
    }


}
