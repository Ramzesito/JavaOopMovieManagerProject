package ru.netology.oop;

public class MovieManager {

    private MovieItem[] movieRepo = new MovieItem[0];
    private int limit;

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        if (limit < 0) {
            this.limit = 5;
        } else {
            this.limit = limit;
        }
    }

    public void addMovie(MovieItem newMovie) {
        if (newMovie == null) {
            return;
        }
        MovieItem[] tmp = new MovieItem[movieRepo.length + 1];
        for (int i = 0; i < movieRepo.length; i++) {
            tmp[i] = movieRepo[i];
        }
        tmp[movieRepo.length] = newMovie;
        movieRepo = tmp;
    }

    public MovieItem[] findAll() {
        return movieRepo;
    }

    public MovieItem[] findLast() {
        int count = this.limit;
        if (count > movieRepo.length) {
            count = movieRepo.length;
        }
        MovieItem[] result = new MovieItem[count];
        for (int i = 0; i < count; i++) {
            result[i] = movieRepo[movieRepo.length - i - 1];
        }
        return result;
    }

    public int getLimit() {
        return this.limit;
    }

}
