package com._onesafe.commons_pool;

import org.apache.commons.pool.PoolableObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by onesafe on 07/01/2019.
 */
public class MyConnectionPoolableObjectFactory implements PoolableObjectFactory {

    private static int count = 0;
    private static Logger logger = LoggerFactory.getLogger(MyConnectionPoolableObjectFactory.class);

    @Override
    public Object makeObject() throws Exception {
        MyConnection myConn = new MyConnection("conn_" + (++count));
        myConn.connect();
        logger.info("make object {}", myConn.getName());
        logger.info(myConn.getName());
        return myConn;
    }

    @Override
    public void destroyObject(Object o) throws Exception {
        MyConnection myConn = (MyConnection)o;
        logger.info(myConn.getName());
        myConn.close();
    }

    @Override
    public boolean validateObject(Object o) {
        MyConnection myConn = (MyConnection)o;
        logger.info(myConn.getName());
        return myConn.isConnected();
    }

    @Override
    public void activateObject(Object o) throws Exception {
        MyConnection myConn = (MyConnection)o;
        logger.info(myConn.getName());
    }

    @Override
    public void passivateObject(Object o) throws Exception {
        MyConnection myConn = (MyConnection)o;
        logger.info(myConn.getName());
    }
}
