/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.interceptor;


import com.amdocs.optima.searchEngine.framework.GlobalExceptionHandler;
import com.amdocs.optima.searchEngine.framework.IConstants;

import com.amdocs.optima.searchEngine.service.IWebManagerService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
//    @Qualifier("webmanagerService")
    private com.amdocs.optima.searchEngine.repo.LogRepository LogRepository;

    private static Logger log = LoggerFactory.getLogger(ViewDetailHandler.class);

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
         
        LogRepository.save(entity).saveQueryLog(request.getSession().getId(), null,request,isSuccess);
        log.debug("view search request saving log done");
        

    }
}
