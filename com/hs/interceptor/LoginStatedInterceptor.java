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
 * 登录状态拦截器
 */
public class LoginStatedInterceptor  implements HandlerInterceptor {
    Logger logger=Logger.getLogger(LoginStatedInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("进入登录状态验证拦截器。。");
        HttpSession session=httpServletRequest.getSession();
        Object object=session.getAttribute("currentUser");
        if (object!=null){
            logger.info("已登录。。。");
            AccountVO accountVO=(AccountVO)object;
            logger.info(accountVO.getUsername());
            logger.info(accountVO.getAid());
            if (accountVO.getAstate().equals("已启用")){
                return true;
            }else {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/tologin.action");
                return false;
            }
        }else {
            logger.info("未登录，先去登陆");
        }
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