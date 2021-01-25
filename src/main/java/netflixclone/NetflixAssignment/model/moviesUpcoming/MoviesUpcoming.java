package netflixclone.NetflixAssignment.model.moviesUpcoming;

import java.util.List;

public class MoviesUpcoming {

    private Dates dates;
    private Integer page;
    private List<Result> results = null;
    private Integer totalPages;
    private Integer totalResults;

    public Dates getDates() {
        return dates;
    }

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
