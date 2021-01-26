
package netflixclone.NetflixAssignment.model.movieDetails;

import java.util.List;

public class Credits {

    public List<Cast> cast = null;
    public List<Crew> crew = null;

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }
}
