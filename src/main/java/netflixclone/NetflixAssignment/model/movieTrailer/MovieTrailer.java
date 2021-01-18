package netflixclone.NetflixAssignment.model.movieTrailer;

import java.util.List;

public class MovieTrailer {


    private Integer id;
    private List<ResultsTrailer> results;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ResultsTrailer> getResults() {
        return results;
    }

    public void setResults(List<ResultsTrailer> results) {
        this.results = results;
    }
}
