/**
 * MovieService.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.service.library;

/*
Dinelle Kotze
219089302
30/8/21
MovieService.java
This is the Movie service class.
 */

import org.springframework.stereotype.Service;
import za.ac.cput.entity.library.Movie;
import za.ac.cput.repository.library.MovieRepository;

import java.util.Set;

/**
 * Instructions
 *  > Make sure you have read the instructions on IService.java before attempting the tasks below.
 *  > Make sure you have completed the task(s) in IMovieService.java before attempting the tasks below.
 *
 * Tasks:
 *  > Implement service using singleton with a link to your repository.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the create method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the read method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the update method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the delete method.
 *  > Write an implementation of the getall method you declared in the interface.
 *
 */

@Service
public class MovieService implements IMovieService
{
    private static MovieService service = null;
    private MovieRepository repository = null;

    private MovieService()
    {
        this.repository = MovieRepository.getRepository();
    }

    public static MovieService getService()
    {
        if (service == null)
        {
            service = new MovieService();
        }

        return service;
    }

    @Override
    public Movie create(Movie movie)
    {
        return this.repository.create(movie);
    }

    @Override
    public Movie read(String id)
    {
        return this.repository.read(id);
    }

    @Override
    public Movie update(Movie movie)
    {
        return this.repository.update(movie);
    }

    @Override
    public boolean delete(String id)
    {
        return this.repository.delete(id);
    }

    @Override
    public Set<Movie> getAll()
    {
        return this.repository.getAll();
    }

    @Override
    public Set<String> getMoviesGivenGenre(String genre)
    {
        return this.repository.getMoviesGivenGenre(genre);
    }

    @Override
    public Set<String> getTitlesByCategoryAndYear(String categoryId, int year)
    {
        return this.repository.getTitlesByCategoryAndYear(categoryId, year);
    }
}
