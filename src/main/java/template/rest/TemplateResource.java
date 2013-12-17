
package template.rest;

import template.MyBean;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import template.Config;
import template.JsonData;


@Path("template")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class TemplateResource {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private MyBean myBean;

    @Inject
    @Config
    private String someString;

    @GET
    public JsonData getData() throws NamingException {
        return new JsonData(myBean.getField(), someString, myBean.hashCode());
    }

}
