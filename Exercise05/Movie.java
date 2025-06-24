package BTVN.Exercise05;

public class Movie {
    private int id;
    private String title;
    private String director;
    private int releaseYear;

//    Constructor có tham số
    public Movie(int id, String title, String director, int releaseYear) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

//    Getter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
