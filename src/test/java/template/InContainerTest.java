
package template;

import java.util.logging.Logger;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import template.rest.TemplateResourceTest;


@Category(RealTest.class)
@RunWith(Arquillian.class)
public class InContainerTest {
    
    private final Logger logger = Logger.getLogger(getClass().getName());

    @Deployment
    public static WebArchive createDeployment() {
        // same as for TemplateResourceTest
        return TemplateResourceTest.createDeployment();
    }

    @Inject
    private MyBean myBean;

    @Test
    public void test() throws Exception {
        logger.info("myBean:" + myBean);
        logger.info("myBean.field:" + myBean.getField());
        Assert.assertEquals("ok", myBean.getField());
    }

}
