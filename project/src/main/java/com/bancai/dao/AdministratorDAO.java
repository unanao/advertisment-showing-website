package com.bancai.dao;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.bancai.utils.sql.AbstractDAO;

/**
 *
 * @author jiangge(zhyanjiang@126.com)
 */
public class AdministratorDAO extends AbstractDAO<Administrator> {

    public String getClassName() {
        return getEntityClass().getName();
    }

    public Class<Administrator> getEntityClass() {
        return Administrator.class;
    }
    public static final String PU_NAME = "BancaiPU";

    public String getPUName() {
        return PU_NAME;
    }

}

