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
public class EnterpriseDAO extends AbstractDAO<Enterprise> {

    public String getClassName() {
        return getEntityClass().getName();
    }

    public Class<Enterprise> getEntityClass() {
        return Enterprise.class;
    }
    public static final String PU_NAME = "BancaiPU";
	public static final String COUNTY = "county";

    public String getPUName() {
        return PU_NAME;
    }

}

