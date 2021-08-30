/**
 * IService.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.service;

/**
 * Instructions
 *   > Do NOT modify this file.
 *   > Your service should be implemented based on the repository.
 *
 * @param <T>
 * @param <ID>
 */
public interface IService<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}