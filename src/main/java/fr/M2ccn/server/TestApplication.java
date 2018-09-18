package fr.M2ccn.server;



import java.util.Set;
import javax.ws.rs.core.Application;

import fr.M2ccn.service.EntiteResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(EntiteResource.class);

        return clazzes;
    }

}