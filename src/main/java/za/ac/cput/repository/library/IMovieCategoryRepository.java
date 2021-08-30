/**
 * IMovieCategoryRepository.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.repository.library;

/*
Dinelle Kotze
219089302
30/8/21
IMovieCategoryRepository.java
This is the MovieCategory repository interface.
 */

import za.ac.cput.entity.library.Movie;
import za.ac.cput.entity.library.MovieCategory;

import java.util.Set;

/**
 * Instructions
 *  > Your repository should be implemented using any Java data structure of your choosing.
 *  > Note that this repository interface does NOT (and should NOT) extend the IRepository.java.
 *
 * Tasks:
 *  > Declare a getall method suitable for your choice of data structure.
 *  > Declare a method that returns all moviecategory entities given a movieid.
 *  > Declare a method that returns all moviecategory entities given a categoryid.
 *
 */
public interface IMovieCategoryRepository
{
    MovieCategory create(MovieCategory movieCategory);
    MovieCategory read(String movieId, String categoryId);
    boolean delete(String movieId, String categoryId);

    public Set<MovieCategory> getAll();
    public Set<MovieCategory> getMovieCategoriesGivenMovieId(String movieId);
    public Set<MovieCategory> getMovieCategoriesGivenCategoryId(String categoryId);
}