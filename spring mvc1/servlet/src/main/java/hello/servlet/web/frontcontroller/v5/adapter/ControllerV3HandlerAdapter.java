package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    //handler가 ControllerV3이 맞는지 확인
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);   //handler 객체가 ControllerV3 타입인지 확인 후 frue or false 맅턴
    }


    @Override
    //핸들러 호출 : 논리 view 이름과 response 모델이 담긴 ModelView 반환
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        //MemberFormControllerV3
        ControllerV3 controller = (ControllerV3) handler;   //핸들러 호출시 ControllerV3로 캐스팅


        Map<String, String> paramMap = createParamMap(request);  //모든 "파라미터", "파라미터 값"을 꺼내옴
        ModelView mv = controller.process(paramMap);             //논리 view 이름과 response 모델이 담긴 ModelView 객체 반환
        //이거와 같다... ex, ControllerV3 controller = MemberFormControllerV3()

        return mv;
    }



    //모든 파라미터 다꺼내서 paramMap에 넣음.
    private Map<String, String> createParamMap(HttpServletRequest request) {

        Map<String, String> paramMap = new HashMap<>();  //"파라미터 명","파라미터 값"을 담을 수 있는 Map 생성

        //paramMap 객체("파라미터 명","파라미터 값") 에 모든 파라미터를 다 넣습니다.
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        //System.out.println(paramMap.get("username"));
        //System.out.println(paramMap.get("age"));

        return paramMap;
    }







}
