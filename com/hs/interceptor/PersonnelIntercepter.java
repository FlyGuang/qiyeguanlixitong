package com.hs.interceptor;

import com.hs.vo.AccountVO;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ss
 * 人事拦截器
 */
public class PersonnelIntercepter implements HandlerInterceptor {

    Logger logger = Logger.getLogger(PersonnelIntercepter.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("进入人事部门权限拦截器.....");
        HttpSession session = httpServletRequest.getSession();
        //会话中获取当前登录用户对象
        Object object = session.getAttribute("currentUser");
        if (object!=null){
            //类型转换
            AccountVO accountVO = (AccountVO) object;
            if (accountVO.getEmployeeVO().getRole().getRid()==3||accountVO.getEmployeeVO().getDept().getDid()==5){
                return true;
            }else {
                logger.info("权限不够");
            }
        }else {
            logger.info("未登录,无法执行相关操作");

        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/tologin.action");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
