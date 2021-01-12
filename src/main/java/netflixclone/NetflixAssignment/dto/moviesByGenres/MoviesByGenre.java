package netflixclone.NetflixAssignment.dto.moviesByGenres;

import java.util.List;

public class MoviesByGenre {

    private Integer page;
    private List<Result> results;
    private Integer totalPages;
    private Integer totalResults;


    public Integer getPage() {
        return page;
    }

    public List<Result> getResults() {
        return results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }
}
