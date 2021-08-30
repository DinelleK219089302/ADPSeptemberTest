/**
 * MovieFactoryTest.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.factory.library;

/*
Dinelle Kotze
219089302
30/8/21
MovieFactoryTest.java
This is the Movie factory test class.
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.library.Movie;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Instructions:
 *  > Make sure you have completed the task on MovieFactory.java.
 *  > Use JUNIT testing framework ONLY.
 *  > Use appropriate assert method(s).
 *
 */
class MovieFactoryTest
{
    /**
     * Tasks:
     *  > Replace the throw exception with your implementation of a test case for createMovie.
     */
    @Test
    void createMovie()
    {
        Movie movie = MovieFactory.createMovie("Nacho Libre", 2006);
        System.out.println(movie);
    }
}