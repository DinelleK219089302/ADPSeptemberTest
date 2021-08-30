/**
 * Movie.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.entity.library;

/*
Dinelle Kotze
219089302
30/8/21
Movie.java
This is the Movie entity class.
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
public class Movie
{
    private String id, title; // DO NOT MODIFY THIS LINE.
    private int year; // DO NOT MODIFY THIS LINE

    private Movie() {}

    private Movie(Builder builder)
    {
        this.id = builder.id;
        this.title = builder.title;
        this.year = builder.year;
    }

    public String getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public int getYear()
    {
        return year;
    }

    @Override
    public String toString()
    {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }

    public static class Builder
    {
        private String id, title;
        private int year;

        public Builder setId(String id)
        {
            this.id = id;

            return this;
        }

        public Builder setTitle(String title)
        {
            this.title = title;

            return this;
        }

        public Builder setYear(int year)
        {
            this.year = year;

            return this;
        }

        public Movie build()
        {
            return new Movie(this);
        }

        public Builder copy(Movie movie)
        {
            this.id = movie.id;
            this.title = movie.title;
            this.year = movie.year;

            return this;
        }
    }
}