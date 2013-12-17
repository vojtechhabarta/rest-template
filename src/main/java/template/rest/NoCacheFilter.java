
package template.rest;

import com.sun.jersey.spi.container.*;
import javax.ws.rs.core.HttpHeaders;


public class NoCacheFilter implements ContainerResponseFilter {

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        response.getHttpHeaders().putSingle(HttpHeaders.CACHE_CONTROL, "no-cache");
        return response;
    }
    
}
