/**
 * MovieCategoryRepository.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.repository.library;

/*
Dinelle Kotze
219089302
30/8/21
MovieCategoryRepository.java
This is the MovieCategory repository class.
 */

import za.ac.cput.entity.generic.Category;
import za.ac.cput.entity.library.Movie;
import za.ac.cput.entity.library.MovieCategory;
import za.ac.cput.repository.generic.CategoryRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Instructions
 *  > Make sure you have read the instructions on IRepository.java before attempting the tasks below.
 *  > Make sure you have completed the task(s) in IMovieCategoryRepository.java before attempting the tasks below.
 *  > Note that no Update operation is needed here.
 *
 * Tasks:
 *  > Implement repository using singleton and your chosen Java data structure.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the create method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the read method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the delete method.
 *  > Write an implementation of the getall method you declared in the interface.
 *  > Write an implementation of the method you declared in the interface that returns all
 *      moviecategory entities given movieid.
 *  > Write an implementation of the method you declared in the interface that returns all
 *      moviecategory entities given categoryid.
 *
 */

public class MovieCategoryRepository implements IMovieCategoryRepository
{
    private static MovieCategoryRepository repository = null;
    private Set<MovieCategory> movieCategoryDB = null;

    private MovieCategoryRepository()
    {
        movieCategoryDB = new HashSet<MovieCategory>();
    }

    public static MovieCategoryRepository getRepository()
    {
        if (repository == null)
        {
            repository = new MovieCategoryRepository();
        }

        return repository;
    }

    @Override
    public MovieCategory create(MovieCategory movieCategory)
    {
        boolean success = movieCategoryDB.add(movieCategory);

        if (!success)
            return null;

        return movieCategory;
    }

    @Override
    public MovieCategory read(String movieId, String categoryId)
    {
        MovieCategory movieCategory = movieCategoryDB.stream()
                .filter(m -> m.getMovieId().equalsIgnoreCase(movieId) && m.getCategoryId().equalsIgnoreCase(categoryId))
                .findAny()
                .orElse(null);

        return movieCategory;
    }

    @Override
    public boolean delete(String movieId, String categoryId)
    {
        MovieCategory removeMovieCategory = read(movieId, categoryId);

        if (removeMovieCategory == null)
            return false;

        movieCategoryDB.remove(removeMovieCategory);

        return true;
    }

    @Override
    public Set<MovieCategory> getAll()
    {
        return movieCategoryDB;
    }

    @Override
    public Set<MovieCategory> getMovieCategoriesGivenMovieId(String movieId)
    {
        Set<MovieCategory> movieCategories = getAll();
        Set<MovieCategory> movieCategoriesGivenMovieId = new HashSet<MovieCategory>();

        for (MovieCategory m : movieCategories)
        {
            if (m.getMovieId().equalsIgnoreCase(movieId))
            {
                movieCategoriesGivenMovieId.add(m);
            }
        }

        return movieCategoriesGivenMovieId;
    }

    @Override
    public Set<MovieCategory> getMovieCategoriesGivenCategoryId(String categoryId)
    {
        Set<MovieCategory> movieCategories = getAll();
        Set<MovieCategory> movieCategoriesGivenCategoryId = new HashSet<MovieCategory>();

        for (MovieCategory m : movieCategories)
        {
            if (m.getCategoryId().equalsIgnoreCase(categoryId))
            {
                movieCategoriesGivenCategoryId.add(m);
            }
        }

        return movieCategoriesGivenCategoryId;
    }
}