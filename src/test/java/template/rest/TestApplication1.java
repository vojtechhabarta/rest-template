
package template.rest;

import javax.ws.rs.ApplicationPath;
import template.helper.AbstractApplication;


@ApplicationPath("realtest1")
public class TestApplication1 extends AbstractApplication {

    public TestApplication1() {
        super(TemplateResource.class);
    }

}
