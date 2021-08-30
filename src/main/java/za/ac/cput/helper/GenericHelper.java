/**
 * GenericHelper.java
 * @Author: your-student-name (student-number)
 * Date: 30 August 2021
 */

package za.ac.cput.helper;

import java.util.UUID;

public class GenericHelper {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNullorEmpty(String s) {
        return (s == null || s.equalsIgnoreCase("null") || s.isEmpty());
    }
}