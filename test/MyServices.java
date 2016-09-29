
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(targetNamespace = "http://my.org/ns/")
public class MyServices {

  @Resource
  WebServiceContext wsContext; 

  /**
   * Web service operation
   */ 
  @WebMethod 
  public String myMethod() { 

    MessageContext mc = wsContext.getMessageContext();
    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
    System.out.println("Client IP = " + req.getRemoteAddr()); 
    return null;
  }

}