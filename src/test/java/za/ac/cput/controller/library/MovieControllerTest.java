/**
 * MovieControllerTest.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.controller.library;

/*
Dinelle Kotze
219089302
30/8/21
MovieControllerTest.java
This is the Movie controller test class.
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.library.Movie;
import za.ac.cput.factory.library.MovieFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Instructions:
 *  > Make sure you have completed the task(s) in MovieController.java before attempting tasks below.
 *  > Use JUNIT testing framework ONLY.
 *  > Use appropriate assert method(s).
 *  > Add the appropriate annotations.
 *  > Remember to run the application first before running these tests.
 *
 * Tasks:
 *  > Write an appropriate test case for each method.
 *  > Ensure your tests run in a right order (Hint: method name ascending).
 *
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerTest
{
    private static Movie movie = MovieFactory.createMovie("Nacho Libre", 2006);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/movie";

    @Test
    void a_create()
    {
        String url = baseURL + "/create";
        ResponseEntity<Movie> postResponse = restTemplate.postForEntity(url, movie, Movie.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        movie = postResponse.getBody();
        System.out.println("Saved data: " + movie);
        assertEquals(movie.getId(), postResponse.getBody().getId());
    }

    @Test
    void b_read()
    {
        String url = baseURL + "/read/" + movie.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Movie> response = restTemplate.getForEntity(url, Movie.class);
        assertEquals(movie.getId(), response.getBody().getId());
    }

    @Test
    void c_update()
    {
        Movie updated = new Movie.Builder().copy(movie).setTitle("Free Nacho").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Movie> response = restTemplate.postForEntity(url, updated, Movie.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete()
    {
        String url = baseURL + "/delete/" + movie.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll()
    {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}