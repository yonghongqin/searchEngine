/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.base.utils;

import com.amdocs.optima.searchEngine.framework.IConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author QINY
 */
public class JdbcUtil {
    
    public static void select(Connection connection, 
                          String sql, 
                          ResultSetProcessor processor, 
                          Object... params) {
        try (Statement ps = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
                   ResultSet.CONCUR_READ_ONLY)) {
            ps.setFetchSize(IConstants.CQ_FETCH_SIZE);
            int cnt=0;
//            for (Object param : params) {
//                ps.setObject(++cnt, param);
//            }
            int processedCount=0;
            try (ResultSet rs = ps.executeQuery(sql)) {
                while (rs.next()) {
                    processedCount++;
                    processor.process(rs);
                if ((++processedCount % 1000) == 0) {
                    LogUtil.info("Processed " + processedCount + "  records",JdbcUtil.class.getName());
            }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
    
    
    public static String clobToString(Clob data) {
    StringBuilder sb = new StringBuilder();
    try {
        Reader reader = data.getCharacterStream();
        try (BufferedReader br = new BufferedReader(reader)) {
            String line;
            while(null != (line = br.readLine())) {
                sb.append(line);
            }
        }
    } catch (SQLException | IOException e) {
        e.printStackTrace();
    }
    return sb.toString();
}
    
}
