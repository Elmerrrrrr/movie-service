package netflixclone.NetflixAssignment.view.movieDetailsView;
import netflixclone.NetflixAssignment.view.movieImagesFaView.MovieLogosView;
import netflixclone.NetflixAssignment.view.movieImagesFaView.MovieLogos;


import java.util.List;

public class MovieDetailsView {


    private Integer id;//
    private String title;//
    private String releaseDate;//
    private Float voteAverage;//
    private String backdropPath;//
    private Integer budget;//
    private Integer revenue;//
    private String homepage;//
    private String originalLanguage;//
    private String originalTitle;//
    private String overview;//
    private Float popularity;
    private String posterPath;//
    private Integer runtime;//
    private Integer voteCount;//
    private String trailer;//
 //   private String movieLogoUrl;//
    private String director;
    // two lists.. Genre is in director model and Cast in view?
    private List<Genre> genres = null;//
    private List<Cast> cast = null;//
    private List<ProductionCompany> productionCompany = null;
    private MovieLogosView movieLogoUrls = null;//


    // getters and setters for the lists, we also need the get methods
    // if we want to display it on the frontend side!
    public List<ProductionCompany> getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(List<ProductionCompany> productionCompany) {
        this.productionCompany = productionCompany;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public List<Genre> getGenres() { return genres; }

    public void setGenres(List<Genre> genres) { this.genres = genres; }

    public MovieLogosView getMovieLogoUrls() {
        return movieLogoUrls;
    }

    public void setMovieLogoUrls(MovieLogosView movieLogoUrls) {
        this.movieLogoUrls = movieLogoUrls;
    }

    // getters and setters for singular objects
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) { this.director = director; }

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

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
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

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
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

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }


}
