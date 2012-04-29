package controllers.camel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Route;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;

import play.Logger;
import play.modules.camel.CamelPlugin;
import play.mvc.Controller;

public class CamelApplication extends Controller {
	
	public static void index(){
		List<Route> routes = CamelPlugin.getCamelContext().getRoutes();
		List<Endpoint> endpoints = new ArrayList<Endpoint>();
		endpoints.addAll(CamelPlugin.getCamelContext().getEndpoints());
		List<String> components = CamelPlugin.getCamelContext().getComponentNames();
		String name = CamelPlugin.getCamelContext().getName();
		String version = CamelPlugin.getCamelContext().getVersion();
		String uptime = CamelPlugin.getCamelContext().getUptime();
		render(routes, endpoints, components, name, version, uptime);
	}
	
}
