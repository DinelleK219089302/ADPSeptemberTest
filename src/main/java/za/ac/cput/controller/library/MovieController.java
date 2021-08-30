/**
 * MovieController.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.controller.library;

/*
Dinelle Kotze
219089302
30/8/21
MovieController.java
This is the Movie controller class.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.library.Movie;
import za.ac.cput.factory.library.MovieFactory;
import za.ac.cput.service.library.MovieService;

import java.util.Set;

/**
 * Instructions:
 *  > Make sure you have completed all tasks in the service package.
 *  > Do not modify class signature.
 *  > Modify the code in this class is to expose your Movie services using a REST api
 *  > Add the annotations as required in your program
 */

@RestController
@RequestMapping("/movie")
public class MovieController
{
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Movie create(@RequestBody Movie movie)
    {
        Movie newMovie = MovieFactory.createMovie(movie.getTitle(), movie.getYear());

        return movieService.create(newMovie);
    }

    @GetMapping("/read/{id}")
    public Movie read(@PathVariable String id)
    {
        return movieService.read(id);
    }

    @PostMapping("/update")
    public Movie update(@RequestBody Movie movie)
    {
        return movieService.update(movie);
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id)
    {
        if (movieService.delete(id))
            return "Deleted movie successfully";
        else
            return "Unable to delete movie";
    }

    @GetMapping("/getall")
    public Set<Movie> getAll()
    {
        return movieService.getAll();
    }
}