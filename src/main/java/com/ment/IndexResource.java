package com.ment;

import java.io.File;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@RequestScoped
public class IndexResource {

    @GET
    public File getIndex() {
        return new File("META-INF/resources/index.html");
    }
}