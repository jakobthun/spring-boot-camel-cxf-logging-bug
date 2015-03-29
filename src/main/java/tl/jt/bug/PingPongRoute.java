package tl.jt.bug;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PingPongRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		// @formatter:off
		from("cxf:/PingPong?serviceClass=" + PingPongService.class.getName())
			.to("log:" + getClass().getName())
			.convertBodyTo(String.class)
			.process(e -> {
				String pingRequest = e.getIn().getBody(String.class);   
				e.getIn().setBody(new Object[] { "Pong: " + pingRequest });
		});
		// @formatter:on

	}

}
