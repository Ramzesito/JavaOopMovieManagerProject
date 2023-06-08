package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void shouldCreateManagerByDefault() {
        MovieManager testManager = new MovieManager();
        int expected = 5;
        Assertions.assertEquals(expected, testManager.getLimit());
    }

    @Test
    public void shouldCreateManagerByLimit() {
        MovieManager testManager = new MovieManager(15);
        int expected = 15;
        Assertions.assertEquals(expected, testManager.getLimit());
    }

    @Test
    public void shouldCreateManagerByNegativeLimit() {
        MovieManager testManager = new MovieManager(-1);
        int expected = 5;
        Assertions.assertEquals(expected, testManager.getLimit());
    }

    @Test
    public void shouldAddOneMovie() {
        MovieManager testManager = new MovieManager();
        MovieItem item1 = new MovieItem("Film1", 0, 1);
        testManager.addMovie(item1);

        MovieItem[] expected = {item1};
        MovieItem[] actual = testManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddManyMovies() {
        MovieManager testManager = new MovieManager();
        MovieItem item1 = new MovieItem("Film1", 0, 1);
        MovieItem item2 = new MovieItem("Film2", 3, 0);
        MovieItem item3 = new MovieItem("Film3", 2, 2);
        testManager.addMovie(item1);
        testManager.addMovie(item2);
        testManager.addMovie(item3);

        MovieItem[] expected = {item1, item2, item3};
        MovieItem[] actual = testManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNoneMovies() {
        MovieManager testManager = new MovieManager();
        testManager.addMovie(null);

        MovieItem[] expected = {};
        MovieItem[] actual = testManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfLimitMoreThanItems() {
        MovieManager testManager = new MovieManager(4);
        MovieItem item1 = new MovieItem("Film1", 0, 1);
        MovieItem item2 = new MovieItem("Film2", 3, 0);
        MovieItem item3 = new MovieItem("Film3", 2, 2);
        testManager.addMovie(item1);
        testManager.addMovie(item2);
        testManager.addMovie(item3);

        MovieItem[] expected = {item3, item2, item1};
        MovieItem[] actual = testManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfLimitEqualItems() {
        MovieManager testManager = new MovieManager(3);
        MovieItem item1 = new MovieItem("Film1", 0, 1);
        MovieItem item2 = new MovieItem("Film2", 3, 0);
        MovieItem item3 = new MovieItem("Film3", 2, 2);
        testManager.addMovie(item1);
        testManager.addMovie(item2);
        testManager.addMovie(item3);

        MovieItem[] expected = {item3, item2, item1};
        MovieItem[] actual = testManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfLimitLessItems() {
        MovieManager testManager = new MovieManager(2);
        MovieItem item1 = new MovieItem("Film1", 0, 1);
        MovieItem item2 = new MovieItem("Film2", 3, 0);
        MovieItem item3 = new MovieItem("Film3", 2, 2);
        testManager.addMovie(item1);
        testManager.addMovie(item2);
        testManager.addMovie(item3);

        MovieItem[] expected = {item3, item2};
        MovieItem[] actual = testManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfLimitIsNull() {
        MovieManager testManager = new MovieManager(0);
        MovieItem item1 = new MovieItem("Film1", 0, 1);
        MovieItem item2 = new MovieItem("Film2", 3, 0);
        MovieItem item3 = new MovieItem("Film3", 2, 2);
        testManager.addMovie(item1);
        testManager.addMovie(item2);
        testManager.addMovie(item3);

        MovieItem[] expected = {};
        MovieItem[] actual = testManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
