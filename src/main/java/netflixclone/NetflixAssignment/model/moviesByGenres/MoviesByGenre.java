
package netflixclone.NetflixAssignment.model.moviesByGenres;

import java.util.List;

public class MoviesByGenre {

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
