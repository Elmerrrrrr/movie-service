package netflixclone.NetflixAssignment.view.moviesByGenreView;

import java.util.List;

public class MoviesByGenreView {

    private Integer page;
    private List<ResultMBG> results;
    private Integer totalPages;
    private Integer totalResults;



    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<ResultMBG> getResults() {
        return results;
    }

    public void setResults(List<ResultMBG> results) {
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
