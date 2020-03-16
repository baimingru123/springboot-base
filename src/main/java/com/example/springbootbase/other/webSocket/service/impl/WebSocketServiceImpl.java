package com.example.springbootbase.other.webSocket.service.impl;

import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author bmr
 * @time 2020-03-04 15:14
 */
@Service
@ServerEndpoint("/ws")
public class WebSocketServiceImpl {
    //静态变量，用来记录当前在线连接数，应该把它设计成线程安全的
    private static int onlineCount=0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServiceImpl对象
    private static CopyOnWriteArraySet<WebSocketServiceImpl> webSocketSet=new CopyOnWriteArraySet<>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新连接加入！当前在线人数为："+getOnlineCount());
        try {
            sendMessage("有新连接加入了");
        }catch (IOException e){
            System.out.println("IO异常");
        }

    }

    //连接关闭调用的方法
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一个连接关闭了，当前在线人数："+getOnlineCount());
    }

    //收到客户端消息后调用的方法
    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("来自客户端的消息："+message);

        //群发消息
        for(WebSocketServiceImpl item:webSocketSet){
            try{
                item.sendMessage(message);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("发送错误");
        error.printStackTrace();
    }

    //发送消息
    private void sendMessage(String message) throws IOException {
            this.session.getBasicRemote().sendText(message);
    }

    //返回在线数
    private static synchronized int getOnlineCount(){
        return onlineCount;
    }

    //增加连接数
    private static synchronized void addOnlineCount(){
        WebSocketServiceImpl.onlineCount++;
    }

    //减少连接数
    private static synchronized void subOnlineCount(){
        WebSocketServiceImpl.onlineCount--;
    }
}
