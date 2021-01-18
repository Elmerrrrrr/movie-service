
package netflixclone.NetflixAssignment.model.moviesTopRated;

import java.util.List;

public class Result {

    public Boolean adult;
    public String backdropPath;
    public List<Integer> genreIds = null;
    public Integer id;
    public String originalLanguage;
    public String originalTitle;
    public String overview;
    public Float popularity;
    public String posterPath;
    public String releaseDate;
    public String title;
    public Boolean video;
    public Float voteAverage;
    public Integer voteCount;


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

    public Float getPopularity() {
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

    public Float getVoteAverage() {
        return voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }
}
