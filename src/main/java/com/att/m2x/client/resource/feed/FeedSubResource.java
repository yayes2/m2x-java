package com.att.m2x.client.resource.feed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;

import com.att.m2x.client.api.feed.Location;
import com.att.m2x.client.api.feed.LogListResponse;
import com.att.m2x.client.api.stream.Value;
import com.att.m2x.client.internal.ExecutableResource;


public class FeedSubResource extends ExecutableResource {

    public FeedSubResource(String path, HttpClient client, ObjectMapper mapper) {
        super(path, client, mapper);
    }

    public StreamSubResource streams() {
        return drill("streams", StreamSubResource.class);
    }

    public TriggerSubResource triggers() {
        return drill("triggers", TriggerSubResource.class);
    }

    public Location location() {
        return execute(prepare().get("location")).status(200).as(Location.class);
    }

    public LogListResponse log() {
        return execute(prepare().get("log")).status(200).as(LogListResponse.class);
    }

    public void addValues(Map<String, List<Value>> items) {
        Map<String, Object> data = new HashMap<String, Object>(1);
        data.put("values", items);

        execute(prepare().post().body(data)).status(204);
    }

}