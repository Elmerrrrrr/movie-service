package netflixclone.NetflixAssignment.service;


import netflixclone.NetflixAssignment.feignclient.FanArtApi;
import netflixclone.NetflixAssignment.feignclient.MovieDbApi;

import netflixclone.NetflixAssignment.model.movieDetails.MovieDetails;
import netflixclone.NetflixAssignment.model.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.model.movieImagesFA.MovieImagesFA;
import netflixclone.NetflixAssignment.model.movieTrailer.MovieTrailer;
import netflixclone.NetflixAssignment.model.moviesByGenres.MoviesByGenre;
import netflixclone.NetflixAssignment.model.moviesTopRated.MoviesTopRated;
import netflixclone.NetflixAssignment.model.moviesUpcoming.MoviesUpcoming;
import netflixclone.NetflixAssignment.model.searchResults.SearchResults;

import netflixclone.NetflixAssignment.view.movieDetailsView.Cast;
import netflixclone.NetflixAssignment.view.movieDetailsView.Genre;
import netflixclone.NetflixAssignment.view.movieDetailsView.MovieDetailsView;
import netflixclone.NetflixAssignment.view.movieDetailsView.ProductionCompany;
import netflixclone.NetflixAssignment.view.movieImagesFaView.MovieLogosView;
import netflixclone.NetflixAssignment.view.movieImagesFaView.MovieLogos;
import netflixclone.NetflixAssignment.view.movieTrailerView.MovieTrailerView;
import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;
import netflixclone.NetflixAssignment.view.moviesByGenreView.ResultMBG;

import netflixclone.NetflixAssignment.view.searchResultsView.searchActorMovieList.Actor;
import netflixclone.NetflixAssignment.view.searchResultsView.searchActorMovieList.SearchActorMovieList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class MovieService {


    private final String lang = "en-US";
    private final String include_adult = "false";
    private final String with_original_language = "en";
    private final String include_video = "true";
    private final String append_to_response = "credits";
    private final String sort_by = "popularity.desc";

    private String gte = "";
    private String lte = "";
    private String actorId = "";
    private String companyId = "";





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

            if (dtoTrailer.getResults() == null || dtoTrailer.getResults().size() == 0){
                trailerView.setYoutubeId("not available");

            }
            else {
                trailerView.setYoutubeId(dtoTrailer.getResults().get(0).getKey());
            }


        return trailerView.getYoutubeId();
    } //done


    public List<MovieLogos> getMovieLogo(int movieId) {

        MovieImagesFA dtoImagesFA = fanArtApi.getMovieImages(movieId, api_keyFA);

        List<MovieLogos> logoList = new ArrayList<>();
        MovieLogos movielogos = new MovieLogos();



        if (dtoImagesFA == null  || dtoImagesFA.getHdmovielogo() == null || dtoImagesFA.getHdmovielogo().size() == 0) {
            movielogos.setUrlHd("notAvailable");
            movielogos.setUrl("notAvailable");
        }
        else {
            if (dtoImagesFA.getMovielogo() != null && dtoImagesFA.getMovielogo().size() == 0 && dtoImagesFA.getMovielogo().get(0).getLang().equals("en")) {
                movielogos.setUrl(dtoImagesFA.getMovielogo().get(0).getUrl());
            } else {
                movielogos.setUrl("no (English) logo available");
            }


            if (dtoImagesFA.getHdmovielogo() != null && dtoImagesFA.getHdmovielogo().size() != 0 && dtoImagesFA.getHdmovielogo().get(0).getLang().equals("en")) {
                movielogos.setUrlHd(dtoImagesFA.getHdmovielogo().get(0).getUrl());
            } else {
                movielogos.setUrlHd("no (English) HD logo available");
            }

        }

        logoList.add(movielogos);

        return logoList;
    }//done


    public MovieImagesFA getMovieImages(int id) {

        return fanArtApi.getMovieImages(id, api_keyFA);
     } //done


    public MoviesTopRated getTopRatedMovies( String pageNr) {

        return movieDbApi.getTopRatedMovies(api_keyMD, lang,"en", pageNr);
    } //done


    public MoviesUpcoming getMoviesUpcoming(String pageNr) {

        return movieDbApi.getMoviesUpcoming(api_keyMD, lang, pageNr);
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
        detailsMovieView.setRuntime(dtoDetailsMovie.getRuntime());



        List<Genre> newGenreList = new ArrayList<>();

        for (int i = 0; i < dtoDetailsMovie.getGenres().size(); i++) {

            Genre genresViewDetailList = new Genre();
            genresViewDetailList.setId(dtoDetailsMovie.getGenres().get(i).getId());
            genresViewDetailList.setName(dtoDetailsMovie.getGenres().get(i).getName());
            newGenreList.add(genresViewDetailList);

        }
        detailsMovieView.setGenres(newGenreList);

        //set director
        for (int i = 0; i <dtoDetailsMovie.getCredits().getCrew().size(); i++) {

            if (dtoDetailsMovie.getCredits().getCrew().get(i).job.equals("Director")) {
                detailsMovieView.setDirector(dtoDetailsMovie.getCredits().getCrew().get(i).getName());
            }
        }
        
        //set cast
        List<Cast> newCastList = new ArrayList<>();

        for (int i = 0; i < dtoDetailsMovie.getCredits().getCast().size(); i++) {
            Cast cast = new Cast();
           cast.setName(dtoDetailsMovie.getCredits().getCast().get(i).getName());
           cast.setId(dtoDetailsMovie.getCredits().getCast().get(i).getId());
           cast.setCharacter(dtoDetailsMovie.getCredits().getCast().get(i).getCharacter());
           cast.setOrder(dtoDetailsMovie.getCredits().getCast().get(i).getOrder());
           newCastList.add(cast);
        }
        //set cast list to max 4 persons
        detailsMovieView.setCast(newCastList.subList(0, dtoDetailsMovie.getCredits().getCast().size() <4 ?0 :4) );


        //set production companies
        List<ProductionCompany> newProductionCompanyList = new ArrayList<>();

        for (int i = 0; i <dtoDetailsMovie.getProductionCompanies().size() ; i++) {

            ProductionCompany productionCompanies = new ProductionCompany();
            productionCompanies.setName(dtoDetailsMovie.getProductionCompanies().get(i).getName());
            productionCompanies.setId(dtoDetailsMovie.getProductionCompanies().get(i).getId());
            productionCompanies.setLogoPath(dtoDetailsMovie.getProductionCompanies().get(i).getLogoPath());
            productionCompanies.setOriginCountry(dtoDetailsMovie.getProductionCompanies().get(i).getOriginCountry());
            newProductionCompanyList.add(productionCompanies);
        }
        detailsMovieView.setProductionCompany(newProductionCompanyList);


        //set trailer info if available
        detailsMovieView.setTrailer(getMovieTrailer(movieId));
        //set logo if available
        detailsMovieView.setMovielogos(getMovieLogo(movieId));



        return detailsMovieView;
    } //done - finalized



    public MovieDetailsView getRandomBannerMovie(){

        int randomPageNr = (((int) (Math.random() * 4))+1);
        MoviesTopRated allMoviesObject = movieDbApi.getTopRatedMovies(api_keyMD, lang, "en", Integer.toString(randomPageNr));

        int totalAmount = 0;
        int randomNr = 0;
        int randomId = 0;

        do {
            totalAmount = allMoviesObject.getResults().size();
            randomNr = ((int) (Math.random() * totalAmount));
            randomId = allMoviesObject.getResults().get(randomNr).getId();

        } while (getMovieDetails(randomId).getMovielogos().isEmpty() ||
                 getMovieDetails(randomId).getMovielogos().get(0).getUrlHd().equals("notAvailable") ||
                 getMovieDetails(randomId).getMovielogos().get(0).getUrlHd().equals("no (English) HD logo available")
                );

        return getMovieDetails(randomId);
    } //done




    /* ------------------Genre Requests------------------ */

    public MovieGenres getMovieGenres() {
        return movieDbApi.getMovieGenres(api_keyMD, lang); //done
    }


    public MoviesByGenreView getMoviesByGenre(String genreId, String pageNr, boolean category, boolean actor, boolean company) {

        MoviesByGenre dtoObject = new MoviesByGenre();

        if (category){
             dtoObject = movieDbApi.getMoviesCategories(api_keyMD, lang, sort_by, gte, lte, with_original_language, pageNr);
        }
        else if (actor){
             dtoObject = movieDbApi.getMoviesByActor(api_keyMD, lang, sort_by, actorId, pageNr);
        }
        else if (company){
             dtoObject = movieDbApi.getMoviesByCompany(api_keyMD, lang, sort_by, companyId, pageNr);
        }
        else {
             dtoObject = movieDbApi.getMoviesByGenre(api_keyMD, genreId, pageNr);
        }

        MoviesByGenreView viewObject = new MoviesByGenreView();

        List<ResultMBG> newList = new ArrayList<>();

        viewObject.setPage(dtoObject.getPage());
        viewObject.setTotalPages(dtoObject.getTotalPages());
        viewObject.setTotalResults(dtoObject.getTotalResults());

        for (int i = 0; i<dtoObject.getResults().size(); i++) {

            ResultMBG result = new ResultMBG();
            result.setId(dtoObject.getResults().get(i).getId());
            result.setTitle(dtoObject.getResults().get(i).getTitle());
            result.setOriginalTitle(dtoObject.getResults().get(i).getOriginalTitle());
            result.setOverview(dtoObject.getResults().get(i).getOverview());
            result.setReleaseDate(dtoObject.getResults().get(i).getReleaseDate());
            result.setOriginalLanguage(dtoObject.getResults().get(i).getOriginalLanguage());
            result.setBackdropPath(dtoObject.getResults().get(i).getBackdropPath());
            result.setPosterPath(dtoObject.getResults().get(i).getPosterPath());

            //add trailer info and logos + runtime
            int movieId = dtoObject.getResults().get(i).getId();
            MovieDetailsView detailsMovie = getMovieDetails(movieId);
            result.setTrailer(detailsMovie.getTrailer());

            List<MovieLogos> newLogoList = new ArrayList<>();
            for (int j = 0; j < detailsMovie.getMovielogos().size(); j++) {
                MovieLogos logos= new MovieLogos();
                logos.setUrl(detailsMovie.getMovielogos().get(j).getUrl());
                logos.setUrlHd(detailsMovie.getMovielogos().get(j).getUrlHd());
                newLogoList.add(logos);
            }
            result.setMovieLogos(newLogoList);
            result.setRuntime(detailsMovie.getRuntime());
            result.setDirector(detailsMovie.getDirector());


            //add result object to the ArrayList
            newList.add(result);
        }

        viewObject.setResults(newList);
        return viewObject;
    } //done - finalized


    public List<ResultMBG> getMoviesByGenreList(String genreId, boolean category, boolean actor, boolean company) {

        MoviesByGenreView dtoObjectP1 = new MoviesByGenreView();
        MoviesByGenreView dtoObjectP2 = new MoviesByGenreView();


        if(category) {
             dtoObjectP1 = getMoviesByGenre("", "1", true, false, false);
             dtoObjectP2 = getMoviesByGenre("", "2", true, false, false);
        }
        else if(actor) {
            dtoObjectP1 = getMoviesByGenre("", "1", false, true, false);
            dtoObjectP2 = getMoviesByGenre("", "2", false, true, false);
        }
        else if(company) {
            dtoObjectP1 = getMoviesByGenre("", "1", false, false, true);
            dtoObjectP2 = getMoviesByGenre("", "2", false, false, true);
        }

        else{
             dtoObjectP1 = getMoviesByGenre(genreId, "1", false, false, false);
             dtoObjectP2 = getMoviesByGenre(genreId, "2", false, false, false);

        }

        List<ResultMBG> newList = new ArrayList<ResultMBG>();


        for (int i = 0; i < dtoObjectP1.getResults().size(); i++) {
            newList.add(dtoObjectP1.getResults().get(i));
        }


        for (int i = 0; i < dtoObjectP2.getResults().size(); i++) {
            newList.add(dtoObjectP2.getResults().get(i));
        }



        return newList;
    } //done - finalized



    /* ------------------Categories Requests------------------ */

    public List<ResultMBG>  getMovies80s() {

        gte = "1980-01-01";
        lte = "1989-12-31";

        return getMoviesByGenreList("", true, false, false);
    }

    public List<ResultMBG> getMovies90s() {

        gte = "1990-01-01";
        lte = "1999-12-31";

        return getMoviesByGenreList("", true,false, false);

    }

    public List<ResultMBG> getMovies00s() {

        gte = "2000-01-01";
        lte = "2010-12-31";

        return getMoviesByGenreList("", true, false, false);
    }

    public List<ResultMBG> getMoviesCompany(String companyIdd) {

         companyId = companyIdd;

        return getMoviesByGenreList("", false, false, true);
    }

    public List<ResultMBG> getMoviesByActor(String actorrId) {

        actorId = actorrId;

        return getMoviesByGenreList("", false,true, false);
    }




    /* ------------------Search Request------------------ */

    public SearchResults getMovieSearchResults(String query) {
        return movieDbApi.getMovieSearchResults(api_keyMD, lang, query,"1");
    }

    public SearchResults getActorSearchResults(String query) {


        return movieDbApi.getActorSearchResults(api_keyMD, lang, query,"1");
    }


    public SearchResults getSearchCompanyResults(String query) {
        return movieDbApi.getSearchCompanyResults(api_keyMD, query);
    }




    public List<Actor> getActorsSearchResultsListSuggestion(String query){

        List<Actor> newActorsList = new ArrayList();
        SearchResults searchResultsActorsP1 = movieDbApi.getActorSearchResults(api_keyMD, lang, query,"1");

        for (int i = 0; i <searchResultsActorsP1.getResults().size() ; i++) {

            Actor actor = new Actor();
            int actorIdSearch = searchResultsActorsP1.getResults().get(i).getId();
            actor.setId(actorIdSearch);
            actor.setName(searchResultsActorsP1.getResults().get(i).getName());
            actor.setPopularity(searchResultsActorsP1.getResults().get(i).getPopularity());
            actor.setMoviesList(new ArrayList<>());
            newActorsList.add(actor);
        }

        newActorsList.sort(Collections.reverseOrder());

        return newActorsList;
    }



    public List<Actor> getActorsSearchResultsList(String query){


        List<Actor> newActorsList = new ArrayList();
        SearchResults searchResultsActorsP1 = movieDbApi.getActorSearchResults(api_keyMD, lang, query,"1");

        for (int i = 0; i <searchResultsActorsP1.getResults().size() ; i++) {

            Actor actor = new Actor();
            int actorIdSearch = searchResultsActorsP1.getResults().get(i).getId();
            actor.setId(actorIdSearch);
            actor.setName(searchResultsActorsP1.getResults().get(i).getName());
            actor.setPopularity(searchResultsActorsP1.getResults().get(i).getPopularity());

                MoviesByGenre movieResultsByActors = movieDbApi.getMoviesByActors(api_keyMD, lang,sort_by,Integer.toString(actorIdSearch),"1");
                List<MovieDetailsView> movieResultsByActorsList = new ArrayList(movieResultsByActors.getResults().subList(0, movieResultsByActors.getResults().size() > 1 ? movieResultsByActors.getResults().size()/2 :0));

              List<MovieDetailsView> movieDetailsResultList = new ArrayList();

            for (int j = 0; j < movieResultsByActorsList.size(); j++) {

                int movieId = movieResultsByActors.getResults().get(j).getId();
                MovieDetailsView movieWithDetails = getMovieDetails(movieId);
                movieDetailsResultList.add(movieWithDetails);
            }

            actor.setMoviesList(movieDetailsResultList);
            newActorsList.add(actor);
        }


        newActorsList.sort(Collections.reverseOrder());


        return newActorsList;

    }




}
