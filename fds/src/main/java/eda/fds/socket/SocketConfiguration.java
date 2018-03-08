/*
package eda.fds.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.ip.tcp.TcpReceivingChannelAdapter;
import org.springframework.integration.ip.tcp.TcpSendingMessageHandler;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.ip.tcp.connection.DefaultTcpNetSSLSocketFactorySupport;
import org.springframework.integration.ip.tcp.connection.DefaultTcpSSLContextSupport;
import org.springframework.integration.ip.tcp.connection.TcpConnection;
import org.springframework.integration.ip.tcp.connection.TcpConnectionCloseEvent;
import org.springframework.integration.ip.tcp.connection.TcpConnectionEvent;
import org.springframework.integration.ip.tcp.connection.TcpConnectionExceptionEvent;
import org.springframework.integration.ip.tcp.connection.TcpConnectionOpenEvent;
import org.springframework.integration.ip.tcp.connection.TcpNetServerConnectionFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.concurrent.ConcurrentHashMap;

@EnableIntegration
@IntegrationComponentScan
@Configuration
@Slf4j
public class SocketConfiguration implements ApplicationListener<TcpConnectionEvent> {
    @Bean
    public AbstractServerConnectionFactory AbstractServerConnectionFactory() {
        TcpNetServerConnectionFactory tcpNetServerConnectionFactory = new TcpNetServerConnectionFactory(11000);
//        DefaultTcpNetSSLSocketFactorySupport tcpNetSSLSocketFactory = tcpSocketFactorySupport();
//        tcpNetServerConnectionFactory.setTcpSocketFactorySupport(tcpNetSSLSocketFactory);
        return tcpNetServerConnectionFactory;
    }


    @Bean
    public DefaultTcpNetSSLSocketFactorySupport tcpSocketFactorySupport() {
        DefaultTcpSSLContextSupport sslContextSupport = new DefaultTcpSSLContextSupport("keystore.jks",
            "trustStore.jks", "123456", "123456");
        sslContextSupport.setProtocol("TLSv1.2");
        DefaultTcpNetSSLSocketFactorySupport tcpSocketFactorySupport = new DefaultTcpNetSSLSocketFactorySupport(sslContextSupport);
        return tcpSocketFactorySupport;
    }

    @Bean
    public static MessageChannel getResponseChannel() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setComponentName("getResponseChannel");
        directChannel.setLoggingEnabled(true);
        return directChannel;
    }

    @Bean
    public static MessageChannel getInputMessageChannel() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setComponentName("inputMessageChannel");
        directChannel.setLoggingEnabled(true);
        return directChannel;
    }

    @Bean
    public MessageChannel invokeChannel() {
        return new DirectChannel();
    }

    @Bean
    public TcpReceivingChannelAdapter in(AbstractServerConnectionFactory connectionFactory) {
        TcpReceivingChannelAdapter adapter = new TcpReceivingChannelAdapter();
        adapter.setOutputChannel(getInputMessageChannel());
        adapter.setConnectionFactory(connectionFactory);
        adapter.setSendTimeout(5000);
        return adapter;
    }

    @ServiceActivator(inputChannel="toClientChannel")
    @Bean
    public TcpSendingMessageHandler out(AbstractServerConnectionFactory connectionFactory) {
        TcpSendingMessageHandler tcpSendingMessageHandler = new TcpSendingMessageHandler();
        tcpSendingMessageHandler.setConnectionFactory(connectionFactory);
        tcpSendingMessageHandler.setLoggingEnabled(true);
        return tcpSendingMessageHandler;
    }
//
//    @Transformer(inputChannel = "invokeChannel", outputChannel = "toClientChannel")
//    public Message<String> headerBeforeSend(String message) throws Exception {
//        log.debug("send message to socket: {}", message);
////        Map.Entry<String, TcpConnection> connectionEntry = GetConnectionEntry();
////        log.debug("connection id is: {}", connectionEntry.getKey());
////        return MessageBuilder.withPayload(message)
////                             .setHeader(IpHeaders.CONNECTION_ID,connectionEntry.getKey())
////                             .build();
//    }

    private static ConcurrentHashMap<String, TcpConnection> tcpConnections = new ConcurrentHashMap<>();

    @Override
    public void onApplicationEvent(TcpConnectionEvent event) {
        TcpConnection source = (TcpConnection) event.getSource();
        if (event instanceof TcpConnectionOpenEvent) {
            log.info("Socket Opened " + source.getConnectionId());
            tcpConnections.put(event.getConnectionId(), source);
        } else if (event instanceof TcpConnectionCloseEvent) {
            log.info("Socket Closed " + source.getConnectionId());
            if(tcpConnections.containsKey(source.getConnectionId()))
                tcpConnections.remove(source.getConnectionId());
        } else if (event instanceof TcpConnectionExceptionEvent) {
            log.error("Error {}",event.getCause().getMessage());
            if(tcpConnections.containsKey(source.getConnectionId()))
                tcpConnections.remove(source.getConnectionId());
        }
    }
}
*/
