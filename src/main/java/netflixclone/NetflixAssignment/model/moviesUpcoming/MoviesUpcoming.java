package netflixclone.NetflixAssignment.model.moviesUpcoming;

import java.util.List;

public class MoviesUpcoming {

    private Dates dates;
    private Integer page;
    private List<ResultUpcoming> results = null;
    private Integer totalPages;
    private Integer totalResults;


    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<ResultUpcoming> getResults() {
        return results;
    }

    public void setResults(List<ResultUpcoming> results) {
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
