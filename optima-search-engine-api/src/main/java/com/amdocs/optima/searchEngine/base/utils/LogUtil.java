
package com.amdocs.optima.searchEngine.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author QINY
 */
public class LogUtil {
    
     public static void info(String message, String className) {
        Logger logger = LoggerFactory.getLogger(className);
        logger.info(message);
    }
    
}
