package com.ment;

import java.util.Scanner;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException exception) {
        Scanner scanner = new Scanner(this.getClass().getResourceAsStream("/META-INF/resources/not-found.html"),
                "UTF-8");
        String text = scanner.useDelimiter("\\A").next();
        scanner.close();
        return Response.status(404).entity(text).build();
    }
}