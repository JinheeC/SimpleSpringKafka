/*
package eda.fds.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.ip.tcp.connection.TcpNioClientConnectionFactory;

public class Socket {
    private static final String STG_FDS = "172.18.176.93";
    private static final String LOCAL_FDS = "localhost";
    private static final Integer FDS_PORT = 11000;
    private static final Integer LOCAL_PORT = 1111;

    @Autowired
    private TcpNioClientConnectionFactory tcpNioClientConnectionFactory;

    @Autowired
    private SimpleGateway gateway;


    public void setUp() {
        tcpNioClientConnectionFactory.setHost(LOCAL_FDS);
        tcpNioClientConnectionFactory.setPort(LOCAL_PORT);
        tcpNioClientConnectionFactory.setSingleUse(true);
        tcpNioClientConnectionFactory.setSoTimeout(10000);
    }
}
*/
