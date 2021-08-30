/**
 * ICategoryService.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.service.generic;

/*
Dinelle Kotze
219089302
30/8/21
ICategoryService.java
This is the Category service interface.
 */

import za.ac.cput.entity.generic.Category;
import za.ac.cput.service.IService;

import java.util.Set;

/**
 * Instructions
 *  > Make sure you have read the instructions on IService.java before attempting the tasks below.
 *
 * Tasks:
 *  > Declare a getall method suitable corresponding to your repository.
 */
public interface ICategoryService extends IService<Category, String>
{
    public Set<Category> getAll();
    public String getIdByGenre(String genre);
}