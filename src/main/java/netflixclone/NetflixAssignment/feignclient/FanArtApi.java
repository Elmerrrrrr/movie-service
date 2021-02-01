package netflixclone.NetflixAssignment.feignclient;


import netflixclone.NetflixAssignment.model.movieImagesFA.MovieImagesFA;
import netflixclone.NetflixAssignment.model.movieTrailer.MovieTrailer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//http://webservice.fanart.tv/v3/movies/550?api_key=db489537503c5044f67e0cac82b2fdc0

@FeignClient(url="http://webservice.fanart.tv/v3/", name = "FanArtApi", decode404 = true)
public interface FanArtApi {

    @GetMapping("movies/{id}")
    MovieImagesFA getMovieImages(@PathVariable("id") int movieId,
                                 @RequestParam(value="api_key") String api_key
                                 );



}
