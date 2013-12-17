
package template.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;


@Provider
@Produces("application/json")
public class JacksonConfigurator implements ContextResolver<ObjectMapper> {

    @Context
    private UriInfo uriInfo;

    private final ObjectMapper defaultMapper = new ObjectMapper();
    private final ObjectMapper prettyPrintMapper = new ObjectMapper();

    public JacksonConfigurator() {
        prettyPrintMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        final String jsonPrettyPrintString = uriInfo.getQueryParameters().getFirst("jsonPrettyPrint");
        if (jsonPrettyPrintString != null && Boolean.parseBoolean(jsonPrettyPrintString)) {
            return prettyPrintMapper;
        } else {
            return defaultMapper;
        }
    }

}
