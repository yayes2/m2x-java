package com.att.m2x.client.util;

import java.util.UUID;

import org.junit.Before;

import com.att.m2x.client.M2XClient;


public class BaseResourceIT extends TestWithSamples {

    protected M2XClient client;
    protected String name;

    @Before
    public void setUp() {
        client = new M2XClient(prop("key.master"), "http://api-m2x.att.citrusbyte.com/v1");
        name = generate();
    }

    protected String generate() {
        return "it-test-" + UUID.randomUUID();
    }

    @Override
    protected String getPathToProperties() {
        String override = System.getenv("it.keys");
        return override == null || override.isEmpty() ? "it/it-keys.xml" : override;
    }

}

