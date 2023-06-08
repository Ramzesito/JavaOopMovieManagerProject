package ru.netology.oop;

public class MovieItem {
    private String name;
    private String[] genres = {"Action", "Animation", "Comedy", "Horror", "Drama", "Adventure"};
    private String[] ageLimits = {"0+", "6+", "12+", "16+", "18+"};
    private int genre;
    private int ageLimit;

    public MovieItem(String name, int genre, int ageLimit) {
        this.name = name;
        this.genre = genre;
        this.ageLimit = ageLimit;
    }

    public String getName() {
        return this.name;
    }

    public int getGenre() {
        return this.genre;
    }

    public int getAgeLimit() {
        return this.ageLimit;
    }
}
