/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.DaoImpl;
import dao.IDao;
import dto.UserDetail;

public class InventoryServiceImpl implements IInventoryService {

    IDao dao;

    @Override
    public String checkCredentials(UserDetail user) {

        String username = user.getName();
        String password = user.getPassword();

        if (username.isEmpty() || password.isEmpty()) {

            return "blankCredentials";

        } else {
            dao = new DaoImpl();
            boolean value = dao.checkCredentials(user);

            if (value) {
                return "validCredentials";
            }
            else{
                return "wrongCredentials";
            }
        }

    }

}
