
package template.rest;

import java.io.File;
import java.util.Map;
import template.helper.AbstractRestTest;
import java.util.logging.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
import org.jboss.shrinkwrap.resolver.api.maven.strategy.AcceptScopesStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import template.RealTest;
import template.TemplateApplication;


@Category(RealTest.class)
@RunWith(Arquillian.class)
public class TemplateResourceTest extends AbstractRestTest {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "realtest.war")
                .addPackages(true, Filters.exclude(TemplateApplication.class), "")
                .addAsResource(EmptyAsset.INSTANCE, "META-INF/beans.xml")
                .addAsWebInfResource("realtest.web.xml", "web.xml")
                .addAsWebInfResource(new File("jetty/jetty-env.xml"))
                .addAsLibraries(Maven.resolver()
                        .loadPomFromFile("pom.xml")
                        .importRuntimeAndTestDependencies()
                        .resolve()
                        .using(new AcceptScopesStrategy(ScopeType.COMPILE))
                        .asFile());
    }

    @Test
    public void testTemplateResource() throws Exception {
        @SuppressWarnings("unchecked")
        final Map<String, Object> responseMsg = resource().path("realtest1/template").get(Map.class);
        logger.info("valueFromBean: " + responseMsg.get("valueFromBean"));
        logger.info("valueFromConfig: " + responseMsg.get("valueFromConfig"));
        logger.info("hash: " + responseMsg.get("hash"));
        Assert.assertEquals("ok", responseMsg.get("valueFromBean"));
        Assert.assertEquals("someValue", responseMsg.get("valueFromConfig"));
        Assert.assertNotNull(responseMsg.get("hash"));
    }

}
