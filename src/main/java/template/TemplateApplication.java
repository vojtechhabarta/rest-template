
package template;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import java.util.*;
import javax.ws.rs.ApplicationPath;
import template.rest.NoCacheFilter;
import template.rest.TemplateResource;


@ApplicationPath("api")
public class TemplateApplication extends PackagesResourceConfig {

    public TemplateApplication() {
        super (getProps());
    }

    private static Map<String, Object> getProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(PackagesResourceConfig.PROPERTY_PACKAGES, TemplateResource.class.getPackage().getName());
        props.put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
        props.put(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, NoCacheFilter.class.getName());
        return props;
    }

}
