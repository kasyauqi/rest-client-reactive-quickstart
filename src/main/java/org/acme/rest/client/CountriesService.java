package org.acme.rest.client;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.Set;
import java.util.concurrent.CompletionStage;

@Path("/v2")
@RegisterRestClient
public interface CountriesService {

    @GET
    @Path("/name/{countryName}")
    Set<Country> getByName(String countryName);

    @GET
    @Path("/name/{region}")
    Set<Country> getByRegion(String region, @QueryParam("city") String city);

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    CompletionStage<Set<Country>> getByNameAsync(String name);

    @GET
    @Path("/name/{name}")
    Uni<Set<Country>> getByNameAsUni(String name);

}
