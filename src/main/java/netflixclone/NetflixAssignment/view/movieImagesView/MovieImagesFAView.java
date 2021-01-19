package netflixclone.NetflixAssignment.view.movieImagesView;

import java.util.List;

public class MovieImagesFAView {



    public String name;
    public String tmdbId;
    public String imdbId;
  //  public List<Moviethumb> moviethumb;
  //  public List<Movielogo> movielogo;
    public String movieLogoUrl;



    public String getMovieLogoUrl() {
        return movieLogoUrl;
    }

    public void setMovieLogoUrl(String movieLogoUrl) {
        this.movieLogoUrl = movieLogoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(String tmdbId) {
        this.tmdbId = tmdbId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

}
