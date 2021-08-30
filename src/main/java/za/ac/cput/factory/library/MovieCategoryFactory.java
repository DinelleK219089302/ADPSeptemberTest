/**
 * MovieCategoryFactory.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.factory.library;

/*
Dinelle Kotze
219089302
30/8/21
MovieCategoryFactory.java
This is the MovieCategory factory class.
 */

import za.ac.cput.entity.library.MovieCategory;
import za.ac.cput.helper.GenericHelper;

public class MovieCategoryFactory {
    /**
     * Instructions:
     *  > Do NOT modify the method signature.
     *  > movieId & categoryId parameters must not be empty, null or "null"
     *
     * Tasks:
     *  > Replace the throw exception (line 25) with your attempt of the factory method.
     *
     * @param movieId
     * @param categoryId
     * @return
     */
    public static MovieCategory createMovieCategory(String movieId, String categoryId)
    { // DO NOT MODIFY THIS LINE.
        if ((GenericHelper.isNullorEmpty(movieId)) || (GenericHelper.isNullorEmpty(categoryId)))
        {
            return new MovieCategory.Builder().build();
        }

        return new MovieCategory.Builder()
                .setMovieId(movieId)
                .setCategoryId(categoryId)
                .build();
    }
}
