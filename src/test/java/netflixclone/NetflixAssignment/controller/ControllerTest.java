package netflixclone.NetflixAssignment.controller;

import netflixclone.NetflixAssignment.feignclient.FanArtApi;
import netflixclone.NetflixAssignment.model.movieImagesFA.MovieImagesFA;
import netflixclone.NetflixAssignment.service.MovieService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.security.RunAs;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.when;


//@WebMvcTest(Controller.class)
@ExtendWith(MockitoExtension.class)
public class ControllerTest {

//    @Autowired
//    private MockMvc mockMvc;


    @Mock
    private MovieService movieService;

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


}










