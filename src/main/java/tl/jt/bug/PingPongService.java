package tl.jt.bug;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface PingPongService {

	@WebMethod
	public String ping(@WebParam(name = "ping") String ping);

}
