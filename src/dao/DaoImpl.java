/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import dto.UserDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.JdbcUtil;

public class DaoImpl  implements IDao{

    @Override
    public boolean checkCredentials(UserDetail user) {
        
       
        try{
            Connection con = JdbcUtil.getJdbcConnection();
            PreparedStatement pstat = con.prepareStatement(SQL_LOGIN);
            ResultSet result;
            
     
            pstat.setString(1, user.getName());
            pstat.setString(2, user.getPassword());
            result = pstat.executeQuery();
            
            if(result.next())
                return true;
            else
                return false;
 
        }catch(Exception e){
            e.printStackTrace();
        }
            
           return false;
    }
}
