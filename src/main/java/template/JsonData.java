
package template;


public class JsonData {

    public String valueFromBean;
    public String valueFromConfig;
    public int hash;

    public JsonData() {
    }

    public JsonData(String valueFromBean, String valueFromConfig, int hash) {
        this.valueFromBean = valueFromBean;
        this.valueFromConfig = valueFromConfig;
        this.hash = hash;
    }

}
