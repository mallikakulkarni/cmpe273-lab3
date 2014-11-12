package edu.sjsu.cmpe.cache.client;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * Created by mallika on 11/11/14.
 */
public class CustomHashFunctionImpl implements CustomHashFunction {

    @Override
    public int hash(String key) {
        HashFunction hf = Hashing.md5();
        HashCode hc = hf.newHasher()
                .putString(key, Charsets.UTF_8)
                .hash();
        return (int) hc.asLong();

    }

    @Override
    public int hash(int key) {
        return hash(key+"");
    }
}
