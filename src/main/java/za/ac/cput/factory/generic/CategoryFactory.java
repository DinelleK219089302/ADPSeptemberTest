/**
 * CategoryFactory.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.factory.generic;

/*
Dinelle Kotze
219089302
30/8/21
CategoryFactory.java
This is the Category factory class.
 */

import za.ac.cput.entity.generic.Category;
import za.ac.cput.helper.GenericHelper;

public class CategoryFactory {
    /**
     * Instructions:
     *  > Do NOT modify the method signature.
     *  > generate a unique key for the id of the category
     *  > genre parameter must not be empty, null or "null".
     *
     * Tasks:
     *  > Replace the throw exception (line 25) with your attempt of the factory method.
     *
     * @param genre
     * @return
     */
    public static Category createCategory(String genre)
    { // DO NOT MODIFY THIS LINE
        if (GenericHelper.isNullorEmpty(genre))
        {
            return new Category.Builder().build();
        }

        String id = GenericHelper.generateId();

        return new Category.Builder()
                .setId(id)
                .setGenre(genre)
                .build();
    }
}