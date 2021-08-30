/**
 * IMovieRepository.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.repository.library;

/*
Dinelle Kotze
219089302
30/8/21
IMovieRepository.java
This is the Movie repository interface.
 */

import za.ac.cput.entity.library.Movie;
import za.ac.cput.repository.IRepository;

import java.util.Set;

/**
 * Instructions
 *  > Make sure you have read the instructions on IRepository.java before attempting the tasks below.
 *
 * Tasks:
 *  > Declare a getall method suitable for your choice of data structure.
 */
public interface IMovieRepository extends IRepository<Movie, String>
{
    public Set<Movie> getAll();
    public Set<String> getMoviesGivenGenre(String genre);
    public Set<String> getTitlesByCategoryAndYear(String categoryId, int year);
}
