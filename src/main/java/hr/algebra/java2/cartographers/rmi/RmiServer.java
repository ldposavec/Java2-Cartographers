package hr.algebra.java2.cartographers.rmi;

import hr.algebra.java2.cartographers.jndi.ConfigurationKey;
import hr.algebra.java2.cartographers.jndi.ConfigurationReader;

import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class RmiServer {
    public static final int RANDMON_PORT_HINT = 0;
    public static final Logger logger = Logger.getLogger(RmiServer.class.getName());

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(ConfigurationReader.getIntValueForKey(ConfigurationKey.RMI_PORT));
            ChatRemoteService chatRemoteService = new ChatRemoteServiceImpl();
            ChatRemoteService skeleton = (ChatRemoteService) UnicastRemoteObject.exportObject(chatRemoteService, RANDMON_PORT_HINT);
            registry.rebind(ChatRemoteService.REMOTE_OBJECT_NAME, skeleton);
            System.out.println("Object registered in RMI registry");
            while (true) {

            }
        } catch (RemoteException e) {
            logger.severe(e.getMessage());
        }
    }
}
