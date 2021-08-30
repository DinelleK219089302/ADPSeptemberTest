/**
 * CategoryService.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.service.generic;

/*
Dinelle Kotze
219089302
30/8/21
CategoryService.java
This is the Category service class.
 */

import za.ac.cput.entity.generic.Category;
import za.ac.cput.repository.generic.CategoryRepository;

import java.util.Set;

/**
 * Instructions
 *  > Make sure you have read the instructions on IService.java before attempting the tasks below.
 *  > Make sure you have completed the task(s) in ICategoryService.java before attempting the tasks below.
 *
 * Tasks:
 *  > Implement service using singleton with a link to your repository.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the create method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the read method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the update method.
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the delete method.
 *  > Write an implementation of the getall method you declared in the interface.
 *
 */

public class CategoryService implements ICategoryService
{
    private static CategoryService service = null;
    private CategoryRepository repository = null;

    private CategoryService()
    {
        this.repository = CategoryRepository.getRepository();
    }

    public static CategoryService getService()
    {
        if (service == null)
        {
            service = new CategoryService();
        }

        return service;
    }

    @Override
    public Category create(Category category)
    {
        return this.repository.create(category);
    }

    @Override
    public Category read(String id)
    {
        return this.repository.read(id);
    }

    @Override
    public Category update(Category category)
    {
        return this.repository.update(category);
    }

    @Override
    public boolean delete(String id)
    {
        return this.repository.delete(id);
    }

    @Override
    public Set<Category> getAll()
    {
        return this.repository.getAll();
    }

    @Override
    public String getIdByGenre(String genre)
    {
        return this.repository.getIdByGenre(genre);
    }
}