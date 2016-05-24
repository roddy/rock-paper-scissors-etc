package net.roddy.rps.utilities;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

/**
 * Utilty class for deploying DRL files and invoking rules.
 */
public class DrlUtilities {

    /**
     * Fires rules for the specified scope. Passes into the session the specified input objects, and adds a global with
     * the specified name.
     * @param scope the scope
     * @param inputs the input objects
     * @param globalName the global's name
     * @param global the global
     */
    public static void fireRulesForScope(String scope, List<Object> inputs, String globalName, Object global) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();

        KieBase kBase = kContainer.getKieBase(scope);
        KieSession session = kContainer.newKieSession(scope+"Session");
        try {
            for(Object input : inputs) {
                session.insert(input);
            }
            session.setGlobal(globalName, global);
            session.fireAllRules();
        } finally {
            session.dispose();
        }
    }
}
