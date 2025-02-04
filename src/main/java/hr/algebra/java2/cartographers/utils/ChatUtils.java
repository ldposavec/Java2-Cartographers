package hr.algebra.java2.cartographers.utils;

import hr.algebra.java2.cartographers.CartographyApplication;
import hr.algebra.java2.cartographers.jndi.ConfigurationKey;
import hr.algebra.java2.cartographers.jndi.ConfigurationReader;
import hr.algebra.java2.cartographers.rmi.ChatRemoteService;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class ChatUtils {
    public static final Logger logger = Logger.getLogger(ChatUtils.class.getName());
    private ChatUtils() {}

    public static Timeline getChatRefreshTimeline(ChatRemoteService chatRemoteService, TextArea chatMessageTextArea)
    {
        Timeline chatMessagesRefreshTimeLine = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            try {

                List<String> chatMessages =  chatRemoteService.getAllMessages();

                StringBuilder textMessagesBuilder = new StringBuilder();

                for(String message : chatMessages) {
                    textMessagesBuilder.append(message).append("\n");
                }

                chatMessageTextArea.setText(textMessagesBuilder.toString());

            } catch (RemoteException ex) {
                logger.severe("Failed to get chat messages!");
            }
        }), new KeyFrame(Duration.seconds(1)));

        chatMessagesRefreshTimeLine.setCycleCount(Animation.INDEFINITE);
        return chatMessagesRefreshTimeLine;
    }

    public static void sendChatMessage(ChatRemoteService chatRemoteService, TextField chatMessageTextField)
    {
        String chatMessage = chatMessageTextField.getText();
        try {
            chatRemoteService.sendChatMessage(CartographyApplication.loggedInPlayer.getPlayerType() + ": " + chatMessage);
        } catch (RemoteException e) {
            logger.severe("Failed to send chat message!");
        }
    }

    public static Optional<ChatRemoteService> initializeChatRemoteService() {

        Optional<ChatRemoteService> chatRemoteServiceOptional
                = Optional.empty();

        try {
            Registry registry = LocateRegistry.getRegistry(
                    ConfigurationReader.getStringValueForKey(ConfigurationKey.HOSTNAME),
                    ConfigurationReader.getIntValueForKey(ConfigurationKey.RMI_PORT));
            chatRemoteServiceOptional = Optional.of((ChatRemoteService) registry.lookup(ChatRemoteService.REMOTE_OBJECT_NAME));
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

        return chatRemoteServiceOptional;
    }
}
