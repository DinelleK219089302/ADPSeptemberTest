/**
 * MovieCategory.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.entity.library;

/*
Dinelle Kotze
219089302
30/8/21
MovieCategory.java
This is the MovieCategory entity class.
 */

/**
 * Instructions:
 *  > Do NOT modify class instance variable declaration.
 *
 * Tasks:
 *  > Add private default constructor
 *  > Add private constructor that accepts a Builder object
 *  > Add getters and toString methods
 *  > Implement class using Builder Pattern ONLY.
 *
 */
public class MovieCategory
{
    private String movieId, categoryId; // DO NOT MODIFY THIS LINE.

    private MovieCategory(){}

    private MovieCategory(Builder builder)
    {
        this.movieId = builder.movieId;
        this.categoryId = builder.movieId;
    }

    public String getMovieId()
    {
        return movieId;
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    @Override
    public String toString()
    {
        return "MovieCategory{" +
                "movieId='" + movieId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }

    public static class Builder
    {
        private String movieId, categoryId;

        public Builder setMovieId(String movieId)
        {
            this.movieId = movieId;

            return this;
        }

        public Builder setCategoryId(String categoryId)
        {
            this.categoryId = categoryId;

            return this;
        }

        public MovieCategory build()
        {
            return new MovieCategory(this);
        }

        public Builder copy(MovieCategory movieCategory)
        {
            this.movieId = movieCategory.movieId;
            this.categoryId = movieCategory.categoryId;

            return this;
        }
    }
}