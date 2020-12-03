/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.interceptor;


import com.amdocs.optima.searchEngine.framework.IConstants;

import com.amdocs.optima.searchEngine.service.IWebManagerService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author QINY
 */
@Component
public class ViewDetailHandler extends HandlerInterceptorAdapter {

    @Autowired
    @Qualifier("webmanagerService")
    private IWebManagerService webmanagerService;

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    Environment conf;


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
    	
        String requestType = request.getRequestURI();
        log.debug("view search request saving log with uri="+requestType);
        String requestId = request.getParameter(IConstants.SEARCH_ID);
        boolean isSuccess = true;
        if (ex != null) {
            isSuccess = false;
            webmanagerService.saveErrorLog(request.getSession().getId(),requestType+"-" + requestId, (short)2, ex);
        }
         
        webmanagerService.saveQueryLog(request.getSession().getId(), null,request,isSuccess);
        log.debug("view search request saving log done");
        

    }
}
