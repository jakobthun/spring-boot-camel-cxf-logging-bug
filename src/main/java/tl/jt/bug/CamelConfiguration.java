package tl.jt.bug;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfiguration {

	/*
	 * Camel SOAP servlet component configuration
	 */
	@Bean
	public ServletRegistrationBean soapServletRegistrationBean() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new CXFServlet(), "/soap/*");
		registration.setName("CXFServlet");
		return registration;
	}

	@Bean
	Bus cxf() {
		return BusFactory.newInstance().createBus();
	}

}
