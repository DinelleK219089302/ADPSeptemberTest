/**
 * MovieCategoryService.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.service.library;

/*
Dinelle Kotze
219089302
30/8/21
MovieCategoryService.java
This is the MovieCategory service class.
 */

import za.ac.cput.entity.library.MovieCategory;
import za.ac.cput.repository.library.MovieCategoryRepository;

import java.util.Set;

/**
 * Instructions
 *  > Make sure you have read the instructions on IService.java before attempting the tasks below.
 *  > Make sure you have completed the task(s) in IMovieCategoryService.java before attempting the tasks below.
 *  > Note that no Update operation is needed here.
 *
 * Tasks:
 *  > Implement service using singleton with a link to your repository.
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
public class MovieCategoryService implements IMovieCategoryService
{
    private static MovieCategoryService service = null;
    private MovieCategoryRepository repository = null;

    private MovieCategoryService()
    {
        this.repository = MovieCategoryRepository.getRepository();
    }

    public static MovieCategoryService getService()
    {
        if (service == null)
        {
            service = new MovieCategoryService();
        }

        return service;
    }

    @Override
    public MovieCategory create(MovieCategory movieCategory)
    {
        return this.repository.create(movieCategory);
    }

    @Override
    public MovieCategory read(String movieId, String categoryId)
    {
        return this.repository.read(movieId, categoryId);
    }

    @Override
    public boolean delete(String movieId, String categoryId)
    {
        return this.repository.delete(movieId, categoryId);
    }

    @Override
    public Set<MovieCategory> getAll()
    {
        return this.repository.getAll();
    }

    @Override
    public Set<MovieCategory> getMovieCategoriesGivenMovieId(String movieId)
    {
        return this.repository.getMovieCategoriesGivenMovieId(movieId);
    }

    @Override
    public Set<MovieCategory> getMovieCategoriesGivenCategoryId(String categoryId)
    {
        return this.repository.getMovieCategoriesGivenCategoryId(categoryId);
    }
}
