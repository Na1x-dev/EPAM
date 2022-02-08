package com.company;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AccountInfo {
    private String nickname;
    private String password;
    private String access;
    private int accId;

    AccountInfo(Node account){
        nickname = getNickname(account);
        password = getPassword(account);
        access = getAccess(account);
    }

    public String getNickname(Node account){
        return account.getChildNodes().item(1).getChildNodes().item(0).getNodeValue();
    }

    public String getPassword(Node account){
        return account.getChildNodes().item(3).getChildNodes().item(0).getNodeValue();
    }

    public String getAccess(Node account){
        return account.getChildNodes().item(5).getChildNodes().item(0).getNodeValue();
    }


    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getAccess() {
        return access;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }


}
