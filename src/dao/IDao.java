/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import dto.UserDetail;


public interface IDao {
    
     String SQL_LOGIN="SELECT * FROM admin WHERE name = ? and password = ?";
     
      public boolean checkCredentials(UserDetail user);
     
     
     
     
    
}
