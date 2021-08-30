/**
 * MovieRepository.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.repository.library;

/*
Dinelle Kotze
219089302
30/8/21
MovieRepository.java
This is the Movie repository class.
 */

import za.ac.cput.entity.library.Movie;
import za.ac.cput.entity.library.MovieCategory;
import za.ac.cput.repository.generic.CategoryRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Instructions
 *  > Make sure you have read the instructions on IRepository.java before attempting the tasks below.
 *  > Make sure you have completed the task(s) in IMovieRepository.java before attempting the tasks below.
 *
 * Tasks:
 *  > Implement repository using singleton and your chosen Java data structure.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the create method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the read method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the update method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the delete method.
 *  > Write an implementation of the getall method you declared in the interface.
 *
 */
public class MovieRepository implements IMovieRepository
{
    private static MovieRepository repository = null;
    private Set<Movie> movieDB = null;

    private MovieRepository()
    {
        this.movieDB = new HashSet<Movie>();
    }

    public static MovieRepository getRepository()
    {
        if (repository == null)
        {
            repository = new MovieRepository();
        }

        return repository;
    }

    @Override
    public Movie create(Movie movie)
    {
        boolean success = movieDB.add(movie);

        if (!success)
            return null;

        return movie;
    }

    @Override
    public Movie read(String movieId)
    {
        for (Movie m : movieDB)
            if (m.getId().equals(movieId))
            {
                return m;
            }

        return null;

            /*
        Movie movie = this.movieDB.stream()
            .filter(m -> m.getId().equals(movieId))
            .findAny()
            .orElse(null);

        return movie;
             */
    }

    @Override
    public Movie update(Movie movie)
    {
        Movie oldMovie = read(movie.getId());

        if (oldMovie != null)
        {
            movieDB.remove(oldMovie);
            movieDB.add(movie);
            return movie;
        }
        else
            return null;
    }

    @Override
    public boolean delete(String movieId)
    {
        Movie removeMovie = read(movieId);

        if (removeMovie == null)
        {
            return false;
        }

        movieDB.remove(removeMovie);

        return true;
    }

    @Override
    public Set<Movie> getAll()
    {
        return movieDB;
    }

    @Override
    public Set<String> getMoviesGivenGenre(String genre)
    {
        MovieCategoryRepository movieCategoryRepository = MovieCategoryRepository.getRepository();
        CategoryRepository categoryRepository = CategoryRepository.getRepository();

        String categoryId = categoryRepository.getIdByGenre(genre);
        String movieId, title;

        Set<String> moviesGivenGenre = new HashSet<String>();
        Set<MovieCategory> movies = movieCategoryRepository.getMovieCategoriesGivenCategoryId(categoryId);

        for (MovieCategory m : movies)
        {
            movieId = m.getMovieId();
            title = read(m.getMovieId()).getTitle();
            moviesGivenGenre.add(title = read(m.getMovieId()).getTitle());
        }

        return moviesGivenGenre;
    }

    @Override
    public Set<String> getTitlesByCategoryAndYear(String categoryId, int year)
    {
        MovieCategoryRepository movieCategoryRepository = MovieCategoryRepository.getRepository();
        CategoryRepository categoryRepository = CategoryRepository.getRepository();

        Set<String> moviesCategoryYear = new HashSet<>();
        String movieId;
        int movieYear;

        Set<MovieCategory> moviesByCategory = movieCategoryRepository.getMovieCategoriesGivenCategoryId(categoryId);

        for (MovieCategory m : moviesByCategory)
        {
            movieId = m.getMovieId();
            movieYear = read(movieId).getYear();
            if (movieYear == year)
            {
                moviesCategoryYear.add(read(movieId).getTitle());
            }
        }

        return moviesCategoryYear;
    }
}
