/**
 * Category.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.entity.generic;

/*
Dinelle Kotze
219089302
30/8/21
Category.java
This is the Category entity class.
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
public class Category
{
    private String id, genre; // DO NOT MODIFY THIS LINE.

    private Category(){}

    private Category(Builder builder)
    {
        this.id = builder.id;
        this.genre = builder.genre;
    }

    public String getId()
    {
        return id;
    }

    public String getGenre()
    {
        return genre;
    }

    @Override
    public String toString()
    {
        return "Category{" +
                "id='" + id + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public static class Builder
    {
        private String id, genre;

        public Builder setId(String id)
        {
            this.id = id;
            return this;
        }

        public Builder setGenre(String genre)
        {
            this.genre = genre;
            return this;
        }

        public Category build()
        {
            return new Category(this);
        }

        public Builder copy(Category category)
        {
            this.id = id;
            this.genre = genre;

            return this;
        }
    }
}