package edu.sjsu.cmpe.cache.client;

/**
 * Created by mallika on 11/11/14.
 */
public interface CustomHashFunction {

    int hash(String key);

    int hash(int key);

}
