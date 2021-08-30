/**
 * IMovieService.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.service.library;

/*
Dinelle Kotze
219089302
30/8/21
IMovieService.java
This is the Movie service interface.
 */

import za.ac.cput.entity.library.Movie;
import za.ac.cput.service.IService;

import java.util.Set;

/**
 * Instructions
 *  > Make sure you have read the instructions on IService.java before attempting the tasks below.
 *
 * Tasks:
 *  > Declare a getall method suitable corresponding to your repository.
 */
public interface IMovieService extends IService<Movie, String>
{
    public Set<Movie> getAll();
    public Set<String> getMoviesGivenGenre(String genre);
    public Set<String> getTitlesByCategoryAndYear(String categoryId, int year);
}
