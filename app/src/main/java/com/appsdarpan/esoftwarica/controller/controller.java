package com.appsdarpan.esoftwarica.controller;

import com.appsdarpan.esoftwarica.model.UserData;

public class controller {
    public boolean CheckUser(UserData sd) {
        if ((sd.getName().equals("admin")) && (sd.getPassword().equals("darpan"))) {
            return true;

        } else {
            return false;
        }
    }
}
//Darpan