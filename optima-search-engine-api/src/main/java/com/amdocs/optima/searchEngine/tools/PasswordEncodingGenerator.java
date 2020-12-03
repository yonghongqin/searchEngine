
package com.amdocs.optima.searchEngine.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
  
public class PasswordEncodingGenerator {
  
    /**
     * @param args
     */
    public static void main(String[] args) {
            String password = "Optima$earch";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            System.out.println(passwordEncoder.encode(password));
            //$2a$10$CVhO5L2sR1nbzJKfBzAI2.Gy8nej70VacDVPNO32DLK.TYZCNCJEi
            
//            BCryptPasswordDecoder passwordDeconder=new BCryptPasswordDecoder();
            
    }
  
}
