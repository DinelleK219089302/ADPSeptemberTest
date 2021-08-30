/**
 * CategoryRepository.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.repository.generic;

/*
Dinelle Kotze
219089302
30/8/21
CategoryRepository.java
This is the Category repository class.
 */

import za.ac.cput.entity.generic.Category;

import java.util.HashSet;
import java.util.Set;

/**
 * Instructions
 *  > Make sure you have read the instructions on IRepository.java before attempting the tasks below.
 *  > Make sure you have completed the task(s) in ICategoryRepository.java before attempting the tasks below.
 *
 * Tasks:
 *  > Implement repository using singleton and your chosen Java data structure.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the create method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the read method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the update method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the delete method.
 *  > Write an implementation of the getall method you declared in the interface.
 *
 */
public class CategoryRepository implements ICategoryRepository
{
    private static CategoryRepository repository = null;
    private Set<Category> categoryDB = null;

    private CategoryRepository()
    {
        this.categoryDB = new HashSet<Category>();
    }

    public static CategoryRepository getRepository()
    {
        if (repository == null)
        {
            repository = new CategoryRepository();
        }

        return repository;
    }

    @Override
    public Category create(Category category)
    {
        boolean success = categoryDB.add(category);

        if (!success)
            return null;

        return category;
    }

    @Override
    public Category read(String categoryId)
    {
        for (Category c : categoryDB)
            if (c.getId().equals(categoryId))
            {
                return c;
            }

        return null;

            /*
        Category category = this.categoryDB.stream()
            .filter( c -> c.getId().equals(categoryId))
            .findAny()
            .orElse(null)

        return category;
             */
    }

    @Override
    public Category update(Category category)
    {
        Category oldCategory = read(category.getId());

        if (oldCategory != null)
        {
            categoryDB.remove(oldCategory);
            categoryDB.add(category);
            return category;
        }
        else
            return null;
    }

    @Override
    public boolean delete(String categoryId)
    {
        Category removeCategory = read(categoryId);

        if (removeCategory == null)
            return false;

        categoryDB.remove(removeCategory);

        return true;
    }

    @Override
    public Set<Category> getAll()
    {
        return categoryDB;
    }

    @Override
    public String getIdByGenre(String genre)
    {
        for (Category c : categoryDB)
            if (c.getGenre().equals(genre))
            {
                return c.getId();
            }

        return null;
    }
}