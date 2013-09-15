package com.bancai.dao;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.free4lab.utils.sql.AbstractDAO;

/**
 *
 * @author jiangge(zhyanjiang@126.com)
 */
public class UserActivationDAO extends AbstractDAO<UserActivation> {

    public String getClassName() {
        return getEntityClass().getName();
    }

    public Class<UserActivation> getEntityClass() {
        return UserActivation.class;
    }
    public static final String PU_NAME = "BancaiPU";

    public String getPUName() {
        return PU_NAME;
    }

}

