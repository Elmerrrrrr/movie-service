package netflixclone.NetflixAssignment.model.moviesByPeriod;

import netflixclone.NetflixAssignment.model.moviesByGenres.ResultByGenre;

import java.util.List;

public class MoviesByPeriod {


    private Integer page;
    private List<ResultByGenre> results;
    private Integer totalPages;
    private Integer totalResults;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<ResultByGenre> getResults() {
        return results;
    }

    public void setResults(List<ResultByGenre> results) {
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
