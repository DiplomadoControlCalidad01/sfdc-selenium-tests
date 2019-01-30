package org.fundacionjala.diplomadoqa.guiautomation.run;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.List;

/**
 * User: Ubaldo Villaseca
 * Date: 1/30/2019
 */
public class DependencyHandler implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> original, ITestContext iTestContext) {
        return null;
    }
}
