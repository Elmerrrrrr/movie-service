
package netflixclone.NetflixAssignment.model.movieDetails;


public class ProductionCompany {

    private Integer id;
    private String logoPath;
    private String name;
    private String originCountry;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public String getName() {
        return name;
    }

    public String getOriginCountry() {
        return originCountry;
    }


}
