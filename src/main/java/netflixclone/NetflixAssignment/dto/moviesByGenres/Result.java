
package netflixclone.NetflixAssignment.dto.moviesByGenres;

import java.util.List;

public class Result {

    private Boolean adult;
    private String backdropPath;
    private List<Integer> genreIds = null;
    private Integer id;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Double popularity;
    private String posterPath;
    private String releaseDate;
    private String title;
    private Boolean video;
    private Double voteAverage;
    private Integer voteCount;



    public Boolean getAdult() {
        return adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public Integer getId() {
        return id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getVideo() {
        return video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }
}
