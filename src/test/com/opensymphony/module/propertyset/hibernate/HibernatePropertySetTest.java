/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.module.propertyset.hibernate;

import com.opensymphony.module.propertyset.BasePropertySetTest;
import com.opensymphony.module.propertyset.DatabaseHelper;


/**
 * This test case tests a propertyset backed by Hibernate
 *
 * @author Eric Pugh (epugh@upstate.com)
 */
public class HibernatePropertySetTest extends BasePropertySetTest {
    //~ Constructors ///////////////////////////////////////////////////////////

    public HibernatePropertySetTest(String s) {
        super(s);
    }

    //~ Methods ////////////////////////////////////////////////////////////////

    public String getType() {
        return "hibernate";
    }

    public void setUp() throws Exception {
        //DatabaseHelper.exportSchemaForJDBC();
        DatabaseHelper.exportSchemaForHibernate();

        DefaultHibernateConfigurationProvider configurationProvider = new DefaultHibernateConfigurationProvider();
        configurationProvider.setConfiguration(DatabaseHelper.getConfiguration());
        configurationProvider.setSessionFactory(DatabaseHelper.getSessionFactory());

        args.put("entityName", "testHibernate");
        args.put("entityId", new Long(3));

        //args.put("sessionFactory",DatabaseHelper.getSessionFactory());
        args.put("configurationProvider", configurationProvider);
        super.setUp();
    }
}