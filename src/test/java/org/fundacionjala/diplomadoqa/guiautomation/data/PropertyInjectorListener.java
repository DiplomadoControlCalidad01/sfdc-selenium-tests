package org.fundacionjala.diplomadoqa.guiautomation.data;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertyInjectorListener implements IAlterSuiteListener {

    private static final Properties properties = new Properties();
    static {
        try (FileReader fileReader = new FileReader("resources/global.properties")){
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alter(List<XmlSuite> suites) {
        XmlSuite suite = suites.get(0);
        Map<String, String> params = new HashMap<>();
        for (Map.Entry<Object, Object> each : properties.entrySet()) {
            params.put(each.getKey().toString(), each.getValue().toString());
        }
        suite.setParameters(params);
    }
}
