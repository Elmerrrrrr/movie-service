package netflixclone.NetflixAssignment.view.moviesTopRated;

import java.util.List;

public class MoviesTopRated {

    public Integer page;
    public List<ResultTopRated> results = null;
    public Integer totalPages;
    public Integer totalResults;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<ResultTopRated> getResults() {
        return results;
    }

    public void setResults(List<ResultTopRated> results) {
        this.results = results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }
}
