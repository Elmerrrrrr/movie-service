package netflixclone.NetflixAssignment.feignclient;


import netflixclone.NetflixAssignment.model.movieImagesFA.MovieImagesFA;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url="http://webservice.fanart.tv/v3/", name = "FanArtApi", fallback =FallBackFanArtApi.class ,decode404 = true)
public interface FanArtApi {

    @GetMapping("movies/{id}")
    MovieImagesFA getMovieImages(@PathVariable("id") int movieId,
                                 @RequestParam(value="api_key") String api_key
                                 );


}
