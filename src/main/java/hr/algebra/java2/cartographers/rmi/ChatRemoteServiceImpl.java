package hr.algebra.java2.cartographers.rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ChatRemoteServiceImpl implements ChatRemoteService {
    private final List<String> messages;

    public ChatRemoteServiceImpl() {
        messages = new ArrayList<>();
    }

    @Override
    public void sendChatMessage(String message) throws RemoteException {
        messages.add(message);
    }

    @Override
    public List<String> getAllMessages() throws RemoteException {
        return messages;
    }
}
