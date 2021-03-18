package com.ruoyi.mq.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ServerEndpoint("/websocket/{username}") //WebSocket客户端建立连接的地址
@Component
@Slf4j
public class WebSocketServer {
    /**
     * 在线人数
     */
    public static int onlineNumber = 0;

    /**
     * 以用户的姓名为key，WebSocket为对象保存起来
     */
    private static Map<String, WebSocketServer> clients = new ConcurrentHashMap<String, WebSocketServer>();
    /**
     * 设置为静态的 公用一个消息map ConcurrentMap为线程安全的map  HashMap不安全
     */
    private static ConcurrentMap<String, List<Map>> messageMap=new ConcurrentHashMap<>();

    /**
     * 会话
     */
    private Session session;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 建立连接
     *
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) throws IOException, InterruptedException {
        onlineNumber++;
        log.info("现在来连接的客户id："+session.getId()+"用户名："+username);
        this.username = username;
        this.session = session;
        clients.put(username, this);
        log.info("有新连接加入！ 当前在线人数" + onlineNumber);
        log.info("存储的列队消息：{}",messageMap);
        List<Map> userMessage = messageMap.get(username);
        if(userMessage!=null){

            log.info("onOpen:"+userMessage);
            for (int i = userMessage.size() - 1; i >= 0; i--) {
                Map messages =userMessage.get(i);
                String o = (String) messages.get(username);
                sendMessageTo(o,username);
            }
            messageMap.remove(username);
        }
    }


    @OnError
    public void onError(Session session, Throwable error) {
        log.info("服务端发生了错误"+error.getMessage());
        error.printStackTrace();
    }
    /**
     * 连接关闭
     */
    @OnClose
    public void onClose()
    {
        onlineNumber--;
        clients.remove(username);
        log.info("{}连接关闭！ 当前在线人数{}",username, onlineNumber);
    }

    /**
     * 收到客户端的消息
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session)
    {
        log.info("来自客户端消息：" + message+"客户端的id是："+session.getId());

    }


    public void sendMessageTo(String message, String ToUserName) throws IOException {
        for (WebSocketServer item : clients.values()) {
            if (item.username.equals(ToUserName) ) {
                item.session.getAsyncRemote().sendText(message);
                log.info("send:0:"+item.username+"==="+ToUserName);
                continue;
            }else {
                List<Map> objects=new ArrayList<>();
                Map<String,String> amp=new HashMap<>();


                //该用户发的离线消息的集合
                amp.put(ToUserName,message);
                objects.add(amp);
                messageMap.put(ToUserName, objects );
                log.info("sendelse:1:"+item.username+"==="+ToUserName);
                log.info(messageMap.toString());
                log.info("用户不在线保存信息");
                continue;

//                if(messageMap.get(ToUserName)!=null){
//                    List list=  messageMap.get(ToUserName);
//                    log.info("有待发送的消息，继续存储");
//                    amp.put(ToUserName,message);
//                    list.add(amp);
//
//                    log.info("sendelse:0:"+item.username+"==="+ToUserName);
//                    continue;
//                }else {
//                    //该用户发的离线消息的集合
//                    amp.put(ToUserName,message);
//                    objects.add(amp);
//                    messageMap.put(ToUserName, objects );
//                    log.info("sendelse:1:"+item.username+"==="+ToUserName);
//
//                    log.info("用户不在线保存信息");
//                    continue;
//                }
            }
        }
    }

    public void sendMessageAll(String message) throws IOException {
        for (WebSocketServer item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    /**
     * 获取消息列队
     * @return
     */
    public ConcurrentMap<String, List<Map>> getMessageMap(){
        return messageMap;
    }

    /**
     * 获取用户消息
     * @param username
     * @return
     */
    public List<Map> getuserMessageMap(String username){
        return messageMap.get(username);
    }

    /**
     * 删除用户消息
     * @param username
     */
    public void delMessageMap(String username){
        messageMap.remove(username);
    }
    public static synchronized int getOnlineCount() {
        return onlineNumber;
    }









//    private final Logger log= LoggerFactory.getLogger(WebSocketServer.class);
//    /**
//     * 存活的session集合（使用线程安全的map保存）
//     */
//    private static Map<String, Session> livingSessions = new ConcurrentHashMap<>();
//
//    /**
//     * 建立连接的回调方法
//     *
//     * @param session 与客户端的WebSocket连接会话
//     * @param userId  用户名，WebSocket支持路径参数
//     */
//    @OnOpen
//    public void onOpen(Session session, @PathParam("userId") String userId) {
//        livingSessions.put(session.getId(), session);
//        log.info(userId + "进入连接");
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session session, @PathParam("userId") String userId) {
//        log.info(userId + " : " + message);
//        sendMessageToAll(userId + " : " + message);
//    }
//
//
//    @OnError
//    public void onError(Session session, Throwable error) {
//        log.info("发生错误");
//        log.error(error.getStackTrace() + "");
//    }
//
//
//    @OnClose
//    public void onClose(Session session, @PathParam("userId") String userId) {
//        livingSessions.remove(session.getId());
//        log.info(userId + " 关闭连接");
//    }
//
//    /**
//     * 单独发送消息
//     *
//     * @param session
//     * @param message
//     */
//    public void sendMessage(Session session, String message) {
//        try {
//            session.getBasicRemote().sendText(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 群发消息
//     *
//     * @param message
//     */
//    public  void sendMessageToAll(String message) {
//        livingSessions.forEach((sessionId, session) -> {
//            sendMessage(session, message);
//        });
//    }
}
