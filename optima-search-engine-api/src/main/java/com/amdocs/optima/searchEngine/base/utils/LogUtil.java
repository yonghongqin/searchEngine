
package com.amdocs.optima.searchEngine.base.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author QINY
 */
public class LogUtil {
    
     public static void info(String message, String className) {
        Logger logger = LogManager.getLogger(className);
        logger.info(message);
    }
    
}
