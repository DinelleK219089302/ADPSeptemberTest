/**
 * MovieRepositoryTest.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.repository.library;

/*
Dinelle Kotze
219089302
30/8/21
MovieRepositoryTest.java
This is the Movie repository test class.
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.library.Movie;
import za.ac.cput.factory.library.MovieFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Instructions:
 *  > Make sure you have completed the task(s) in MovieRepository.java before attempting tasks below.
 *  > Use JUNIT testing framework ONLY.
 *  > Use appropriate assert method(s).
 *
 * Tasks:
 *  > Replace the throw exception with test case for the create method.
 *  > Replace the throw exception with test case for the read method.
 *  > Replace the throw exception with test case for the update method.
 *  > Replace the throw exception with test case for the delete method.
 *  > Write a test case for the getall method.
 *  > Ensure your tests run in a right order (Hint: method name ascending).
 *
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MovieRepositoryTest
{
    private static MovieRepository repository = MovieRepository.getRepository();
    private static Movie movie = MovieFactory.createMovie("Nacho Libre", 2006);

    @Test
    void a_create()
    {
        Movie created = repository.create(movie);
        assertEquals(movie.getId(), created.getId());
        System.out.println("Created " + created);
    }

    @Test
    void b_read()
    {
        Movie read = repository.read(movie.getId());
        assertNotNull(read);
        System.out.println("Read " + read);
    }

    @Test
    void c_update()
    {
        Movie updated = new Movie.Builder().copy(movie).setTitle("Free Nacho").build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated " + updated);
    }

    @Test
    void e_delete()
    {
        boolean success = repository.delete(movie.getId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll()
    {
        System.out.println("Show All:");
        System.out.println(repository.getAll());
    }
}