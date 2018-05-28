//package hello.utils;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.messaging.simp.stomp.StompSessionHandler;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import hello.tables.DemandesAmis;
//import hello.tables.Notifications;
//import hello.utils.websocketHandlers.NotificationsHandler;
//@CrossOrigin(origins="*")
//@Controller    // This means that this class is a Controller
//
//
//public class Websocket {
//	private  final String URL_CONTROLLER = "/flux/";
//	private  final String URL_FLUX_NOTIFICATION = URL_CONTROLLER+"notification/";
//	/* @Autowired
//	    private  SimpMessagingTemplate template;*/
//    @Autowired
//    public SimpMessageSendingOperations messagingTemplate;
//	
//  
//	public  void sendNotification(Notifications notif) throws IOException {
//		messagingTemplate.convertAndSend(URL_FLUX_NOTIFICATION+notif.getUtilisateur().getId(),notif);
//		
//		NotificationsHandler.broadcastNotifToUser(notif);
//    }
//	public  void sendDemandeAmis(DemandesAmis demande) throws IOException {
//		messagingTemplate.convertAndSend(URL_FLUX_NOTIFICATION+demande.getFrom().getId(),demande);
//		
//		NotificationsHandler.broadcastNotifToUser(demande);
//    }
//	public Websocket() {};
//}
