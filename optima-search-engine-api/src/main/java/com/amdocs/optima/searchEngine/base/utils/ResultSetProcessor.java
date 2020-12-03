
package com.amdocs.optima.searchEngine.base.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author QINY
 */
@FunctionalInterface
public interface ResultSetProcessor {

    public void process(ResultSet resultSet) 
                        throws SQLException;

}
