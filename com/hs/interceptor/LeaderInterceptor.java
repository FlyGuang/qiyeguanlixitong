package com.hs.interceptor;

import com.hs.vo.AccountVO;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author km
 * leader权限拦截器
 */
public class LeaderInterceptor implements HandlerInterceptor {

    Logger logger=Logger.getLogger(LeaderInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("进入董事长leader权限拦截器");
        //获取session
        HttpSession session= httpServletRequest.getSession();
        //从session中获取对象
        Object obj=session.getAttribute("currentUser");
        //创建userVO对象
        AccountVO accountVO=(AccountVO)obj;
        if (obj!=null){
            logger.info(accountVO.getEmployeeVO().getEname());
            if (accountVO.getEmployeeVO().getRole().getRid()==3){
                return true;
            }else {
                logger.info("权限不够");
            }
        }else {
            logger.info("未登录，不能继续下面内容");
        }
        //跳转到指定页面
        logger.info(httpServletRequest.getContextPath());
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/tologin.action");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
