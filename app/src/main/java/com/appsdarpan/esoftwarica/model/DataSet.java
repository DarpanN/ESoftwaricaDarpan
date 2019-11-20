package com.appsdarpan.esoftwarica.model;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
    private String username;
    private String useraddress;
    private String userage;
    private String usergender;

    public DataSet(String username, String useraddress, String userage, String usergender) {
        this.username = username;
        this.useraddress = useraddress;
        this.userage = userage;
        this.usergender = usergender;
    }

    static List<DataSet> Slist=new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    public String getUsergender() {
        return usergender;
    }

    public void setUsergender(String usergender) {
        this.usergender = usergender;
    }

    public static List<DataSet> getSlist() {
        return Slist;
    }

    public static void setSlist(List<DataSet> slist) {
        Slist = slist;
    }
}
