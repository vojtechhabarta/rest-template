
package template.helper;

import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;


public abstract class AbstractApplication extends DefaultResourceConfig {

    public AbstractApplication(Class<?>... classes) {
        super(classes);
        getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
    }

}
