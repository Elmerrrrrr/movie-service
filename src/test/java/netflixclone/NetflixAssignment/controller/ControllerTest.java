package netflixclone.NetflixAssignment.controller;

import netflixclone.NetflixAssignment.feignclient.MovieDbApi;
import netflixclone.NetflixAssignment.model.movieGenres.Genre;
import netflixclone.NetflixAssignment.model.movieGenres.MovieGenres;
import netflixclone.NetflixAssignment.model.movieImagesFA.MovieImagesFA;
import netflixclone.NetflixAssignment.model.moviesTopRated.ResultTopRated;
import netflixclone.NetflixAssignment.model.moviesUpcoming.MoviesUpcoming;
import netflixclone.NetflixAssignment.model.moviesUpcoming.ResultUpcoming;
import netflixclone.NetflixAssignment.model.moviesTopRated.MoviesTopRated;

import netflixclone.NetflixAssignment.view.movieDetailsView.Cast;
import netflixclone.NetflixAssignment.view.movieDetailsView.MovieDetailsView;
import netflixclone.NetflixAssignment.view.movieImagesFaView.MovieLogos;
import netflixclone.NetflixAssignment.view.movieImagesFaView.MovieLogosView;
import netflixclone.NetflixAssignment.view.moviesByGenreView.MoviesByGenreView;
import netflixclone.NetflixAssignment.view.moviesByGenreView.ResultMBG;

import netflixclone.NetflixAssignment.service.MovieService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


//@WebMvcTest(Controller.class)
@ExtendWith(MockitoExtension.class)
public class ControllerTest {

//    @Autowired
//    private MockMvc mockMvc;


    @Mock
    private MovieService movieService;

    @Mock
    private MovieDbApi movieDbApi;

    @InjectMocks
    private Controller controller;


    @Test
    void getMovieImages() throws Exception {

//        RequestBuilder requestImages = MockMvcRequestBuilders
//                                        .get("/movie/images/550")
//                                        .accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestImages).andReturn();
//        assertEquals("", result.getResponse());


        MovieImagesFA movieImagesFATestObj = new MovieImagesFA();
        movieImagesFATestObj.setName("Fight Club");
        movieImagesFATestObj.setMovielogo(new ArrayList<>());
        movieImagesFATestObj.setHdmovielogo(new ArrayList<>());

        when(movieService.getMovieImages(550)).thenReturn(movieImagesFATestObj);

        MovieImagesFA returnCheckObj = controller.getMovieImages(550);
        assertEquals(movieImagesFATestObj.getName(), returnCheckObj.getName());
        assertEquals(movieImagesFATestObj.getMovielogo(), returnCheckObj.getMovielogo());
        assertEquals(movieImagesFATestObj.getHdmovielogo(), returnCheckObj.getHdmovielogo());


    }


    @Test
    void getMovieLogos() {

        MovieLogosView movieTestObj = new MovieLogosView();
        List<MovieLogos> logoList= new ArrayList<>();
        MovieLogos logos = new MovieLogos();

        logos.setUrl("http:///550.com");
        logos.setUrlHd("http:///550.com");
        logoList.add(logos);
        movieTestObj.setMovielogos(logoList);


        when(movieService.getMovieLogo(550)).thenReturn(movieTestObj);

        MovieLogosView returnCheckObj = controller.getMovieLogos(550);
        assertEquals(movieTestObj.getMovielogos().get(0).getUrl(), returnCheckObj.getMovielogos().get(0).getUrl());
        assertEquals(movieTestObj.getMovielogos().get(0).getUrlHd(), returnCheckObj.getMovielogos().get(0).getUrlHd());

    }


    @Test
    void getUpcomingMovies() {

        MoviesUpcoming movieTestObj = new MoviesUpcoming();
        List<ResultUpcoming> newList = new ArrayList<>();
        movieTestObj.setResults(newList);

        when(movieDbApi.getMoviesUpcoming("4b9e0a6d10b150a86ea776f903aaaf8c","en-US","1")).thenReturn(movieTestObj);
        MoviesUpcoming returnCheckObj = controller.getUpcomingMovies("1");
        assertEquals(movieTestObj.getResults(),returnCheckObj.getResults());
    }



    @Test
    void getTopRatedMovies() {

        MoviesTopRated movieTestObj = new MoviesTopRated();
        List<ResultTopRated> newList = new ArrayList<>();
        movieTestObj.setResults(newList);

        when(movieService.getTopRatedMovies("1")).thenReturn(movieTestObj);
        MoviesTopRated returnCheckObj = controller.getTopRatedMovies("1");
        assertEquals(movieTestObj.getResults(),returnCheckObj.getResults());

    }

    @Test
    void getMovieDetails() {

        MovieDetailsView movieTestObj = new MovieDetailsView();
        List<Cast> newList = new ArrayList<>();
        movieTestObj.setCast(newList);

        when(movieService.getMovieDetails(123)).thenReturn(movieTestObj);
        MovieDetailsView returnCheckObj = controller.getMovieDetails(123);
        assertEquals(movieTestObj.getCast(),returnCheckObj.getCast());

    }


    @Test
    void getRandomMovie() {

        MovieDetailsView movieTestObj = new MovieDetailsView();
        List<Cast> newList = new ArrayList<>();
        movieTestObj.setCast(newList);

        when(movieService.getRandomBannerMovie()).thenReturn(movieTestObj);
        MovieDetailsView returnCheckObj = controller.getRandomMovie();
        assertEquals(movieTestObj.getCast(), returnCheckObj.getCast());

    }

    @Test
    void getMovieGenres() {

        MovieGenres movieTestObj = new MovieGenres();
        List<Genre> newList = new ArrayList<>();
        movieTestObj.setGenres(newList);

        when(movieService.getMovieGenres()).thenReturn(movieTestObj);
        MovieGenres returnCheckObj = controller.getMovieGenres();
        assertEquals(movieTestObj.getGenres(), returnCheckObj.getGenres());

    }

    @Test
    void getMoviesByGenre() {

        MoviesByGenreView movieTestObj = new MoviesByGenreView();
        List<ResultMBG> newList = new ArrayList<>();
        movieTestObj.setResults(newList);

        when(movieService.getMoviesByGenre("123","1",false, false, false)).thenReturn(movieTestObj);
        MoviesByGenreView returnCheckObj = controller.getMoviesByGenre("123","1");
        assertEquals(movieTestObj.getResults(), returnCheckObj.getResults());

    }

    @Test
    void getMoviesByGenre40() {

        List<ResultMBG> newTestList = new ArrayList<>();
        ResultMBG movieTestObj = new ResultMBG();
        movieTestObj.setDirector("Sunny Liu");
        movieTestObj.setTrailer("abcdefg");
        movieTestObj.setId(123);
        newTestList.add(movieTestObj);

        when(movieService.getMoviesByGenreList("1",false, false,false)).thenReturn(newTestList);
        List<ResultMBG> returnCheckObj = controller.getMoviesByGenre40("1");

//
//        when(movieService.getMoviesByGenreList("1",true, false,false)).thenReturn(newTestList);
//        List<ResultMBG> returnCheckObj2= controller.getMoviesByGenre40("1");
//
//        when(movieService.getMoviesByGenreList("1",false, true,false)).thenReturn(newTestList);
//        List<ResultMBG> returnCheckObj3= controller.getMoviesByGenre40("1");
//
//        when(movieService.getMoviesByGenreList("1",false, false,true)).thenReturn(newTestList);
//        List<ResultMBG> returnCheckObj4= controller.getMoviesByGenre40("1");

        assertEquals(newTestList.get(0).getDirector(), returnCheckObj.get(0).getDirector());
        assertEquals(newTestList.get(0).getTrailer(), returnCheckObj.get(0).getTrailer());
        assertEquals(newTestList.get(0).getId(), returnCheckObj.get(0).getId());


//
//        assertEquals(newTestList.get(0).getDirector(), returnCheckObj2.get(0).getDirector());
//        assertEquals(newTestList.get(0).getTrailer(), returnCheckObj2.get(0).getTrailer());
//        assertEquals(newTestList.get(0).getId(), returnCheckObj2.get(0).getId());
//
//
//
//        assertEquals(newTestList.get(0).getDirector(), returnCheckObj3.get(0).getDirector());
//        assertEquals(newTestList.get(0).getTrailer(), returnCheckObj3.get(0).getTrailer());
//        assertEquals(newTestList.get(0).getId(), returnCheckObj3.get(0).getId());
//
//
//
//        assertEquals(newTestList.get(0).getDirector(), returnCheckObj4.get(0).getDirector());
//        assertEquals(newTestList.get(0).getTrailer(), returnCheckObj4.get(0).getTrailer());
//        assertEquals(newTestList.get(0).getId(), returnCheckObj4.get(0).getId());


    }

    @Test
    void getMovies80s() {

        List<ResultMBG> newTestList = new ArrayList<>();
        ResultMBG movieTestObj = new ResultMBG();
        movieTestObj.setDirector("Sunny Liu");
        movieTestObj.setTrailer("abcdefg");
        movieTestObj.setId(123);
        newTestList.add(movieTestObj);

        when(movieService.getMovies80s()).thenReturn(newTestList);
        List<ResultMBG> returnCheckObj = controller.getMovies80s();
        assertEquals(newTestList.get(0).getDirector(), returnCheckObj.get(0).getDirector());
        assertEquals(newTestList.get(0).getTrailer(), returnCheckObj.get(0).getTrailer());
        assertEquals(newTestList.get(0).getId(), returnCheckObj.get(0).getId());

    }

    @Test
    void getMovies90s() {

        List<ResultMBG> newTestList = new ArrayList<>();
        ResultMBG movieTestObj = new ResultMBG();
        movieTestObj.setDirector("Sunny Liu");
        movieTestObj.setTrailer("abcdefg");
        movieTestObj.setId(123);
        newTestList.add(movieTestObj);

        when(movieService.getMovies90s()).thenReturn(newTestList);
        List<ResultMBG> returnCheckObj = controller.getMovies90s();
        assertEquals(newTestList.get(0).getDirector(), returnCheckObj.get(0).getDirector());
        assertEquals(newTestList.get(0).getTrailer(), returnCheckObj.get(0).getTrailer());
        assertEquals(newTestList.get(0).getId(), returnCheckObj.get(0).getId());

    }

    @Test
    void getMovies00s() {

        List<ResultMBG> newTestList = new ArrayList<>();
        ResultMBG movieTestObj = new ResultMBG();
        movieTestObj.setDirector("Sunny Liu");
        movieTestObj.setTrailer("abcdefg");
        movieTestObj.setId(123);
        newTestList.add(movieTestObj);

        when(movieService.getMovies00s()).thenReturn(newTestList);
        List<ResultMBG> returnCheckObj = controller.getMovies00s();
        assertEquals(newTestList.get(0).getDirector(), returnCheckObj.get(0).getDirector());
        assertEquals(newTestList.get(0).getTrailer(), returnCheckObj.get(0).getTrailer());
        assertEquals(newTestList.get(0).getId(), returnCheckObj.get(0).getId());

    }

    @Test
    void getMoviesByActor() {

        List<ResultMBG> newTestList = new ArrayList<>();
        ResultMBG movieTestObj = new ResultMBG();
        movieTestObj.setDirector("Sunny Liu");
        movieTestObj.setTrailer("youTubeKey");
        movieTestObj.setId(123);
        newTestList.add(movieTestObj);

        when(movieService.getMoviesByActor("123")).thenReturn(newTestList);
        List<ResultMBG> returnCheckObj = controller.getMoviesByActor("123");
        assertEquals(newTestList.get(0).getDirector(), returnCheckObj.get(0).getDirector());
        assertEquals(newTestList.get(0).getTrailer(), returnCheckObj.get(0).getTrailer());
        assertEquals(newTestList.get(0).getId(), returnCheckObj.get(0).getId());

    }

    @Test
    void getMoviesCompany() {


        List<ResultMBG> newTestList = new ArrayList<>();
        ResultMBG movieTestObj = new ResultMBG();
        movieTestObj.setDirector("Sunny Liu");
        movieTestObj.setTrailer("youTubeKey");
        movieTestObj.setId(123);
        newTestList.add(movieTestObj);

        when(movieService.getMoviesCompany("123")).thenReturn(newTestList);
        List<ResultMBG> returnCheckObj = controller.getMoviesCompany("123");
        assertEquals(newTestList.get(0).getDirector(), returnCheckObj.get(0).getDirector());
        assertEquals(newTestList.get(0).getTrailer(), returnCheckObj.get(0).getTrailer());
        assertEquals(newTestList.get(0).getId(), returnCheckObj.get(0).getId());


    }

    @Test
    void getSearchResult() {
    }

    @Test
    void getSearchCompanyResults() {
    }



}










