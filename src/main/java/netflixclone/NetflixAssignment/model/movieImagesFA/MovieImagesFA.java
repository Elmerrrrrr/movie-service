package netflixclone.NetflixAssignment.model.movieImagesFA;

import java.util.List;

public class MovieImagesFA {



    private String name;
    private String tmdbId;
    private String imdbId;
    private List<Movieposter> movieposter;
    private List<Hdmovielogo> hdmovielogo;
    private List<Moviedisc> moviedisc;
    private List<Moviethumb> moviethumb;
    private List<Hdmovieclearart> hdmovieclearart;
    private List<Moviebackground> moviebackground;
    private List<Moviebanner> moviebanner;
    private List<Movielogo> movielogo;
    private List<Movieart> movieart;
    private String status;

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

    public List<Movieposter> getMovieposter() {
        return movieposter;
    }

    public void setMovieposter(List<Movieposter> movieposter) {
        this.movieposter = movieposter;
    }

    public List<Hdmovielogo> getHdmovielogo() {
        return hdmovielogo;
    }

    public void setHdmovielogo(List<Hdmovielogo> hdmovielogo) {
        this.hdmovielogo = hdmovielogo;
    }

    public List<Moviedisc> getMoviedisc() {
        return moviedisc;
    }

    public void setMoviedisc(List<Moviedisc> moviedisc) {
        this.moviedisc = moviedisc;
    }

    public List<Moviethumb> getMoviethumb() {
        return moviethumb;
    }

    public void setMoviethumb(List<Moviethumb> moviethumb) {
        this.moviethumb = moviethumb;
    }

    public List<Hdmovieclearart> getHdmovieclearart() {
        return hdmovieclearart;
    }

    public void setHdmovieclearart(List<Hdmovieclearart> hdmovieclearart) {
        this.hdmovieclearart = hdmovieclearart;
    }

    public List<Moviebackground> getMoviebackground() {
        return moviebackground;
    }

    public void setMoviebackground(List<Moviebackground> moviebackground) {
        this.moviebackground = moviebackground;
    }

    public List<Moviebanner> getMoviebanner() {
        return moviebanner;
    }

    public void setMoviebanner(List<Moviebanner> moviebanner) {
        this.moviebanner = moviebanner;
    }

    public List<Movielogo> getMovielogo() {
        return movielogo;
    }

    public void setMovielogo(List<Movielogo> movielogo) {
        this.movielogo = movielogo;
    }

    public List<Movieart> getMovieart() {
        return movieart;
    }

    public void setMovieart(List<Movieart> movieart) {
        this.movieart = movieart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
