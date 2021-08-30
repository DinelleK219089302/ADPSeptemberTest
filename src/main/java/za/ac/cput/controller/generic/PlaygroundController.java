/**
 * PlaygroundController.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

/**
 * Instructions:
 *  > Make sure you have completed all tasks in the service package.
 *  > Do not modify class signature.
 *  > Complete the code in this class to expose your functionality below using a REST api
 *  > Add the annotations as required in your program
 */
package za.ac.cput.controller.generic;

/*
Dinelle Kotze
219089302
30/8/21
PlaygroundController.java
This is the Playground controller class.
 */

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.service.library.MovieCategoryService;
import za.ac.cput.service.library.MovieService;

import java.util.Set;

public class PlaygroundController
{
    @Autowired
    private MovieService movieService;
    /**
     * Tasks:
     *  > Replace the throw exception with an implementation that returns titles of all movies
     *      for a particular genre.
     *
     * @param genre
     * @return
     */
    public Set<String> getMovieTitlesByGenre(String genre)
    {
        return movieService.getMoviesGivenGenre(genre);
    }

    /**
     * Tasks:
     *  > Replace the throw exception with an implementation that returns the title of all movies
     *      of a given category in a given year.
     *
     * @param categoryId
     * @param year
     * @return
     */
    public Set<String> getMovieTitlesByCategoryforYear(String categoryId, int year)
    {
        return movieService.getTitlesByCategoryAndYear(categoryId, year);
    }
}
