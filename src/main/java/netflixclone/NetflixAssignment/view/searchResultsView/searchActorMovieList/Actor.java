package netflixclone.NetflixAssignment.view.searchResultsView.searchActorMovieList;


import netflixclone.NetflixAssignment.view.movieDetailsView.MovieDetailsView;


import java.util.List;

public class Actor implements Comparable<Actor> {

    private Integer id;
    private String name;
    private Float popularity;
    private List<MovieDetailsView> moviesList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public List<MovieDetailsView> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<MovieDetailsView> moviesList) {
        this.moviesList = moviesList;
    }


    @Override
    public int compareTo(Actor o) {
        return this.getPopularity().compareTo(o.getPopularity());
    }

}
