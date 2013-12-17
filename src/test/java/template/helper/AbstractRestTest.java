
package template.helper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import java.net.URL;
import org.jboss.arquillian.test.api.ArquillianResource;


public abstract class AbstractRestTest {

    @ArquillianResource
    private URL baseURL;

    private Client client;


    protected WebResource resource() {
        if (client == null) {
            final ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            client = Client.create(clientConfig);
        }
        return client.resource("" + baseURL);
    }

}
