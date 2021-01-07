package netflixclone.NetflixAssignment.feignclient.moviesTopRated;

import java.util.List;

public class MoviesTopRated {

    public Integer page;
    public List<Result> results = null;
    public Integer totalPages;
    public Integer totalResults;

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
