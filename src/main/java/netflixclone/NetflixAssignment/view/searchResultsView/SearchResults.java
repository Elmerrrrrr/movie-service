
package netflixclone.NetflixAssignment.view.searchResultsView;

import java.util.List;

public class SearchResults {

    private Integer page;
    private List<ResultSearch> results = null;
    private Integer totalPages;
    private Integer totalResults;



    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<ResultSearch> getResults() {
        return results;
    }

    public void setResults(List<ResultSearch> results) {
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
