package org.acme.rest.client;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.concurrent.CompletionStage;

@Path("/country")
public class CountriesResource {

    @RestClient
    CountriesService countriesService;

    @RestClient
    MockLabClient mocklabClient;

    @GET
    @Path("/name/{name}")
    @Blocking
    public Set<Country> name(String name) {
        return countriesService.getByName(name);
    }

    @GET
    @Path("/name-async/{name}")
    public CompletionStage<Set<Country>> nameAsync(String name) {
        return countriesService.getByNameAsync(name);
    }

    @GET
    @Path("/name-uni/{name}")
    public Uni<Set<Country>> nameUni(String name) {
        return countriesService.getByNameAsUni(name);
    }

    @GET
    @Path("/slow")
    public Uni<Response> slow() {
        return mocklabClient.getSlow5();
    }
}
