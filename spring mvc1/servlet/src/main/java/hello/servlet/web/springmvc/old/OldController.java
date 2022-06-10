package hello.servlet.web.springmvc.old;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("/springmvc/old-controller")  //springBean의 이름 지정
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return null;
    }


}