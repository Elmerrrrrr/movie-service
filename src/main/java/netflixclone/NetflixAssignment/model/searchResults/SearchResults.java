
package netflixclone.NetflixAssignment.model.searchResults;

import java.util.List;

public class SearchResults {

    private Integer page;
    private List<ResultSearchItem> results = null;
    private Integer totalPages;
    private Integer totalResults;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<ResultSearchItem> getResults() {
        return results;
    }

    public void setResults(List<ResultSearchItem> results) {
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
