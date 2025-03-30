//package Chat;
//
//
//import com.mysql.cj.Session;
//import jakarta.websocket.*;
//import jakarta.websocket.server.ServerEndpoint;
//
//
//import java.io.IOException;
//import java.util.Set;
//import java.util.concurrent.CopyOnWriteArraySet;
//
//@ServerEndpoint("/chat")
//public class ChatServer {
//    private static final Set<Session> clients = new CopyOnWriteArraySet<>();
//
//    @OnOpen
//    public void onOpen(Session session) {
//        clients.add(session);
//        System.out.println("Nouvelle connexion : " + session.getId());
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        System.out.println("Message reçu : " + message);
//        broadcast(message);
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        clients.remove(session);
//        System.out.println("Client déconnecté : " + session.getId());
//    }
//
//    private void broadcast(String message) {
//        for (Session client : clients) {
//            try {
//                client.getBasicRemote().sendText(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
