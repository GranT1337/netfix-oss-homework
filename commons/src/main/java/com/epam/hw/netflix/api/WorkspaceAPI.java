package com.epam.hw.netflix.api;

import com.epam.hw.netflix.domain.Workspace;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.epam.hw.netflix.domain.OSFamily.WINDOWS;
import static java.util.UUID.randomUUID;


@FeignClient(name = "workspaces-api",
        fallback = WorkspaceAPI.WorkspaceClientFallback.class)
public interface WorkspaceAPI {

    @RequestMapping(value = "/workspaces/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Workspace getWorkspaceById(@PathVariable("id") String id);

    @Component
    class WorkspaceClientFallback implements WorkspaceAPI {

        @Override
        public Workspace getWorkspaceById(String id) {
            return new Workspace("0000001", 1, 1, randomUUID().toString(), WINDOWS);
        }
    }

}
