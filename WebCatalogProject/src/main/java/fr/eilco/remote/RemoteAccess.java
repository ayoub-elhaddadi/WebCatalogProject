package fr.eilco.remote;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.eilco.ejb.AccessCatalogueBeanRemote;
import fr.eilco.ejb.GestionCommandeBeanRemote;

public class RemoteAccess {

	public static AccessCatalogueBeanRemote getAccessCatalogueBeanRemote() {
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context;
		try {
			context = new InitialContext(jndiProperties);
	        final String appName = "WebCatalogEAR";
	        final String moduleName = "GestionnaireCommandes";
	        final String beanName = "WebCatalogJNDI";
	        final String viewClassName = AccessCatalogueBeanRemote.class.getName();
	
	        AccessCatalogueBeanRemote remote = (AccessCatalogueBeanRemote) context
	                .lookup("ejb:" + appName + "/" + moduleName + "/" + beanName + "!" + viewClassName);
	
	        return remote;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static GestionCommandeBeanRemote getGestionCommandeBeanRemote() {
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context;
		try {
			context = new InitialContext(jndiProperties);
	        final String appName = "WebCatalogEAR";
	        final String moduleName = "GestionnaireCommandes";
	        final String beanName = "GestionCommandeBean";
	        final String viewClassName = GestionCommandeBeanRemote.class.getName();
	
	        GestionCommandeBeanRemote remote = (GestionCommandeBeanRemote) context
	                .lookup("ejb:" + appName + "/" + moduleName + "/" + beanName + "!" + viewClassName);
	
	        return remote;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
