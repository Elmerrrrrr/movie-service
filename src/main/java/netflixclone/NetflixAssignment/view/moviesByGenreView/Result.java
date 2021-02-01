package netflixclone.NetflixAssignment.view.moviesByGenreView;


import netflixclone.NetflixAssignment.view.movieImagesFaView.MovieLogosView;

public class Result {

    private String backdropPath;
    private Integer id;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private String posterPath;
    private String releaseDate;
    private String title;
    private String trailer; //added in service class
    private MovieLogosView movieLogos = null;//



    public MovieLogosView getMovieLogos() {
        return movieLogos;
    }

    public void setMovieLogos(MovieLogosView movieLogos) {
        this.movieLogos = movieLogos;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
