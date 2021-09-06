package cn.ducklfew.simpleWebSoket.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Slf4j
@Component
@ServerEndpoint(value = "/websocket/{userId}")
public class WebSocketEndpoint
{
    private Session session;
    @OnOpen
    public void onOpen(Session session, @PathParam("userId")String userId)
    {
        System.out.println("userId"+userId);
        System.out.println(session);
        //会话保存到连接池
        SessionPool.sessions.put(userId,session);
    }

    @OnClose
    public void onClose(Session session) throws IOException
    {
        SessionPool.close(session.getId());
    }
    @OnMessage
    public void onMessage(String message,Session session)
    {
        System.out.println("message"+message);
        SessionPool.sendMessage(message);
    }
}
