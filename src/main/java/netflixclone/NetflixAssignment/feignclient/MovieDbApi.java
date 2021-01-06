package netflixclone.NetflixAssignment.feignclient;


import netflixclone.NetflixAssignment.feignclient.genre.MovieGenres;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url="https://api.themoviedb.org/3/",name = "MovieDataBaseClientApi")
public interface MovieDbApi {

    //top rated movies
    @RequestMapping(method = RequestMethod.GET , path ="movie/top_rated?api_key=4b9e0a6d10b150a86ea776f903aaaf8c&page=1")
    public MovieResponse getTopRatedMovies(@RequestParam(value="language") String language);


    // get movie genres https://api.themoviedb.org/3/genre/movie/list?api_key=4b9e0a6d10b150a86ea776f903aaaf8c&language=en-US
    @RequestMapping(method = RequestMethod.GET , path ="/genre/movie/list?api_key=4b9e0a6d10b150a86ea776f903aaaf8c")
    public MovieGenres getMovieGenres(@RequestParam(value="language") String language);


}

