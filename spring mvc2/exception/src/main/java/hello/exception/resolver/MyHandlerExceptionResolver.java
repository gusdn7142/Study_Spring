package hello.exception.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        //log.info("call resolver", ex);

        try {
            if (ex instanceof IllegalArgumentException) {   //IllegalArgumentException("500")을 "400" 오류로 변경
                log.info("IllegalArgumentException resolver to 400");

                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());   //"400" error를 보냄
                return new ModelAndView();   //새로운 ModelAndView 반환
            }

        } catch (IOException e) {
            log.error("resolver ex", e);
        }

        return null;
    }







}