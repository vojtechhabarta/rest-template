
package template;

import java.util.*;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.*;
import javax.sql.DataSource;


@ApplicationScoped
public class ApplicationConfiguration {

    private final Map<String, String> configuration;

    // todo load from properties file
    public ApplicationConfiguration() {
        this.configuration = new LinkedHashMap<>();
        this.configuration.put("someString", "someValue");
    }


    @Produces @Config String getConfigValue(InjectionPoint p) {
        final String key = p.getMember().getName();
        return configuration.get(key);
    }

    @Resource(name = "jdbc/TemplateDS")
    @Produces DataSource dataSource;

    @Produces EntityManagerFactory getEntityManagerFactory(InjectionPoint p) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("template-unit");
        final EntityManager entityManager = emf.createEntityManager();
        entityManager.close();
        return emf;
    }

}
