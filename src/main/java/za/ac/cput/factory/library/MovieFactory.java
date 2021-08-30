/**
 * MovieFactory.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.factory.library;

/*
Dinelle Kotze
219089302
30/8/21
MovieFactory.java
This is the Movie factory class.
 */

import za.ac.cput.entity.library.Movie;
import za.ac.cput.helper.GenericHelper;

public class MovieFactory
{
    /**
     * Instructions:
     *  > Do NOT modify the method signature.
     *  > generate a unique key for the id of the movie
     *  > year parameter must be 4 digits.
     *  > year parameter must not be older than 1900 and/or in the future.
     *  > title parameter must not be empty, null or "null".
     *
     * Tasks:
     *  > Replace the throw exception (line 28) with your attempt of the factory method.
     *
     * @param title
     * @param year
     * @return
     */
    public static Movie createMovie(String title, int year)
    { // DO NOT MODIFY THIS LINE.
        if ((GenericHelper.isNullorEmpty(title)) || (String.valueOf(year).length() > 4) || (year < 1900) || (year > 2021))
        {
            return new Movie.Builder().build();
        }

        String id = GenericHelper.generateId();

        return new Movie.Builder()
                .setId(id)
                .setTitle(title)
                .setYear(year)
                .build();
    }
}