
package template;

import javax.enterprise.context.RequestScoped;


@RequestScoped
public class MyBean {

    private final String field = "ok";

    public String getField() {
        return field;
    }

}
