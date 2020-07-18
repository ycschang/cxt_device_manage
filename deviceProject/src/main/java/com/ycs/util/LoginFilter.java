package com.ycs.util; 
import javax.servlet.Filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @program: ssm
 * @description: 实现一个判断某值是否为空的过滤器
 * @author: ycs
 * @create: 2019-04-29 13:15
 **/

public class LoginFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest)arg0;
        HttpServletResponse response = (HttpServletResponse)arg1;
        HttpSession session = request.getSession();
        // 没有userName为空就转发到登陆页面
        if(session.getAttribute("user")==null){

            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);

//            response.sendRedirect(request.getContextPath()+"/index.jsp");  //重定向就相当于地址栏输入 也不能随便访问jsp
        }else{
            // 不为空，就继续请求下一级资源（继续访问）
            arg2.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
